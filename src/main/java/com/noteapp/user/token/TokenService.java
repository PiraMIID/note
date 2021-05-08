package com.noteapp.user.token;

import com.noteapp.config.SecurityConfig;
import com.noteapp.exception.helper.ApiExceptionJsonMessage;
import com.noteapp.exception.httpException.ApiConflictException;
import com.noteapp.user.User;
import com.noteapp.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private TokenRepository tokenRepository;
    private UserRepository userRepository;

    public TokenService(TokenRepository tokenRepository, UserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    User save(SignupRequest signupRequest)  {
        checkNotDataNotAlreadyInDB(signupRequest);
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(SecurityConfig.passwordEncoder().encode(signupRequest.getPassword()));
        user.setRole("ROLE_USER");
        user.setEmail(signupRequest.getEmail());
//       todo:  this  will be change after confirm token on email
        user.setAccountNonLocked(false);
        return userRepository.save(user);
    }

    private void checkNotDataNotAlreadyInDB(SignupRequest signupRequest) {
        ApiExceptionJsonMessage errMessage = new ApiExceptionJsonMessage();
        String msg = "";
        if(checkUsernameIsTaken(signupRequest.getUsername())) {
            msg = "Username " + signupRequest.getUsername() + " is taken. ";
            errMessage.add("username",msg);

        }
        if(checkEmailIsTaken(signupRequest.getEmail())) {
//            todo: if user exists and and confirm email take details from database and send again
            msg = "Email " + signupRequest.getEmail() + " is taken";
            errMessage.add("email",msg);
        }
        if(!msg.isEmpty()) {
            throw new ApiConflictException(errMessage);
        }
    }


    private boolean checkUsernameIsTaken(String username) {
        return userRepository.existsByUsername(username);
    }

    /**
     * @param email - email of new user
     * @return  boolean as true if other user account is use this email
     */
    private boolean checkEmailIsTaken(String email) { return userRepository.existsByEmail(email); }
}
