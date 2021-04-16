package com.noteapp.jwt;

import com.google.common.net.HttpHeaders;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class JwtConfig {

    private String secretKey = "securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecure";
    private String tokenPrefix = "Bearer ";
    private Integer tokenExpirationAfterDays = 10;

    public JwtConfig() {
    }

    public String getSecretKey() {
        return secretKey;
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

    public Integer getTokenExpirationAfterDays() {
        return tokenExpirationAfterDays;
    }

    public void setTokenExpirationAfterDays(Integer tokenExpirationAfterDays) {
        this.tokenExpirationAfterDays = tokenExpirationAfterDays;
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}
