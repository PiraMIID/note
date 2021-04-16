package com.noteapp.jwt;

import com.noteapp.config.SecurityConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/*
 * 1. check Principals User
 * 2. if ok: create token and save to database
 *   */


@Component
public abstract class JwtUsernameAndPasswordAuthenticationFilter implements Filter {



    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        System.out.println(response.getTrailerFields().get().keySet().stream().filter(s -> s.equals("data")));
//        Authentication authorization = AuthenticationManagerBuilder.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        response.getTrailerFields().get().keySet().stream().filter(s -> s.equals("data"))
//                        ,response.getTrailerFields().get().keySet().stream().filter(s -> s.equals("credential"))));
        return (Authentication) User.builder().build().getAuthorities();

    }


    public void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(2)))
                .signWith(Keys.hmacShaKeyFor("secretkey".getBytes()))
                .compact();

        System.out.println("token :" + token);

        response.addHeader("Authorization", "Bearer " + token);
        chain.doFilter(request,response);
    }

}
