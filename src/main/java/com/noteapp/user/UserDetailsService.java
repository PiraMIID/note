package com.noteapp.user;

import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

    private UserDetailsRepository userDetailsRepository;

    public UserDetailsService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }
}
