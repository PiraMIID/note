package com.noteapp.user.token;

import com.noteapp.config.SecurityConfig;
import com.noteapp.exception.helper.ApiExceptionJsonMessage;
import com.noteapp.exception.httpException.ApiConflictException;
import com.noteapp.exception.httpException.ApiNotFoundException;
import com.noteapp.exception.mail.ApiMailMessageException;
import com.noteapp.user.User;
import com.noteapp.user.UserRepository;
import com.noteapp.user.email.MailService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.persistence.TransactionRequiredException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

//asdg
@Service
@EnableScheduling
public class TokenService {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final MailService mailService;

    public TokenService(TokenRepository tokenRepository, UserRepository userRepository, MailService mailService) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    @Transactional
    @Scheduled(cron = "0 * * * * ?") //1min
    public void checkTokensIsNotExpires() {
        tokenRepository.removeAllByTokenExpiresAtLessThan(LocalTime.now());
        userRepository.removeIfAccountIsNotConfirmAndTokenNotExist();

    }

    User save(SignupRequest signupRequest) {
        checkNotDataNotAlreadyInDB(signupRequest);
        User saveUser = saveUser(signupRequest);
        Token token = createToken(saveUser);
        sendEmailWithToken(saveUser, token);
        return userRepository.save(saveUser);
    }

    void sendEmailWithToken(User user, Token token) {
        try {
            mailService.sendMail(user.getEmail(), user.getUsername(),token.getToken());
        } catch (MessagingException e) {
            throw new ApiMailMessageException("mail", "Valid process of sending massage on email. Please check email is correct ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * if token will not confirm in 2 min user will be remove
     * this mechanism is usefully cause if new user create user with wrong email  can wait 2 min and use same username again.
     */
    Token createToken(User saveUser) {
        String token = UUID.randomUUID().toString();
        Token tokenEntity = new Token();
        tokenEntity.setToken(token);
        tokenEntity.setTokenExpiresAt(LocalTime.now().plusMinutes(2));
        tokenEntity.setUser(saveUser);
        return tokenRepository.save(tokenEntity);
    }

    User saveUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(SecurityConfig.passwordEncoder().encode(signupRequest.getPassword()));
        user.setRole("ROLE_USER");
        user.setEmail(signupRequest.getEmail());
        user.setAccountNonLocked(false);
        return userRepository.save(user);
    }

    void checkNotDataNotAlreadyInDB(SignupRequest signupRequest) {
        ApiExceptionJsonMessage errMessage = new ApiExceptionJsonMessage();
        String msg = "";
        if (checkUsernameIsTaken(signupRequest.getUsername())) {
            msg = "Username " + signupRequest.getUsername() + " is taken. ";
            errMessage.add("username", msg);

        }
        if (checkEmailIsTaken(signupRequest.getEmail())) {
            msg = "Email " + signupRequest.getEmail() + " is taken";
            errMessage.add("email", msg);
        }
        if (!msg.isEmpty()) {
            throw new ApiConflictException(errMessage);
        }
    }


    boolean checkUsernameIsTaken(String username) { return userRepository.existsByUsername(username); }
    boolean checkEmailIsTaken(String email) { return userRepository.existsByEmail(email); }


    public User confirmAccount(String token) throws TransactionRequiredException {
        User newUser = getUserWitActiveToken(token);
        newUser.setAccountNonLocked(true);
        User save = userRepository.save(newUser);
        return save;
    }

    private User getUserWitActiveToken(String token) {
        Optional<Token> byToken = tokenRepository.findByToken(token);
        return getUserFromToken(byToken);
    }

    private User getUserFromToken(Optional<Token> byToken) {
        return byToken
                .orElseThrow(
                        () -> {
                            throw new ApiNotFoundException("Token", "token is not found");
                        }
                )
                .getUser();
    }
}

