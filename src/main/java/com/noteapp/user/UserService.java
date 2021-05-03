package com.noteapp.user;


import com.noteapp.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).get();
    }


    public User save(SinginRequest singinRequest) {
        User user = new User();
        user.setUsername(singinRequest.getUsername());
        user.setPassword(SecurityConfig.passwordEncoder().encode(singinRequest.getPassword()));
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }

}
