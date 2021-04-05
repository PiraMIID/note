package com.noteapp.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.noteapp.config.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private UserService userService;

    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("jwt", authResult.getPrincipal())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(12)))
                .signWith(Keys.hmacShaKeyFor("secretKeysecretKeysecretKeysecretKeysecretKey".getBytes()))
                .compact();

        response.addHeader("jwt", "Bearer " + token);
        doFilter(request,response,chain);
    }

    @Override
    protected AuthenticationManager getAuthenticationManager() {
        return (AuthenticationManager) userService.loadUserByUsername("dawid").getAuthorities();

    }
}
