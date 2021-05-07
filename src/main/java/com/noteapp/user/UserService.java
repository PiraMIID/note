package com.noteapp.user;


import com.noteapp.config.SecurityConfig;
import com.noteapp.exception.httpException.ApiConflictException;
import com.noteapp.exception.helper.ApiExceptionJsonMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username)  {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }

    User save(SinginRequest singinRequest)  {
        checkNotDataNotAlreadyInDB(singinRequest);
        User user = new User();
        user.setUsername(singinRequest.getUsername());
        user.setPassword(SecurityConfig.passwordEncoder().encode(singinRequest.getPassword()));
        user.setRole("ROLE_USER");
        user.setEmail(singinRequest.getEmail());
//        this  will be change after confirm token on email
        user.setAccountNonLocked(false);
        return userRepository.save(user);
    }

    private void checkNotDataNotAlreadyInDB(SinginRequest singinRequest) {
        ApiExceptionJsonMessage errMessage = new ApiExceptionJsonMessage();
        String msg = "";
        if(checkUsernameIsTaken(singinRequest.getUsername())) {
            msg = "Username " + singinRequest.getUsername() + " is taken. ";
            errMessage.add("username",msg);

        }
        if(checkEmailIsTaken(singinRequest.getEmail())) {
            msg = "Email " + singinRequest.getEmail() + " is taken";
            errMessage.add("email",msg);
        }
        if(!msg.isEmpty()) {
            throw new ApiConflictException(errMessage);
        }
    }
    boolean checkUsernameIsTaken(String username) {
        return userRepository.existsByUsername(username);
    }
    boolean checkEmailIsTaken(String email) { return userRepository.existsByEmail(email); }

}
