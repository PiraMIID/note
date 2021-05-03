package com.noteapp.user.token;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

//    createToken(){}

//    senadToUser() {}

}
