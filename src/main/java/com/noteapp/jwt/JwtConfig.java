package com.noteapp.jwt;


import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Configuration(value = "application.jwt")
public class JwtConfig {

    private String secretKey ="secretKeysecretKeysecretKeysecretKeysecretKey";
    private String tokenPrefix;
    private Integer tokenExpirationAfterDays;

    public JwtConfig() {
    }

    public String getSecretKey() {
        return String.valueOf(Keys.hmacShaKeyFor(secretKey.getBytes()));
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public Integer getTokenExpiration() {
        return tokenExpirationAfterDays;
    }

    public void setTokenExpiration(Integer tokenExpiration) {
         this.tokenExpirationAfterDays = tokenExpirationAfterDays;
    }
    public Integer getTokenExpirationAfterDays() {
        return tokenExpirationAfterDays;
    }

    public String getAuthorizationHeader() {
        System.out.println("In JwtConfig getAuthorizationHeader: " + HttpHeaders.AUTHORIZATION);
        return HttpHeaders.AUTHORIZATION;
    }
}
