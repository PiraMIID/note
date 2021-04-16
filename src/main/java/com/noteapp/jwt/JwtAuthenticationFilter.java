package com.noteapp.jwt;


import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    /*
    * 1. Taken jwt from request headers
    * 2. Find user with this token
    * 3. check than token is not to old
    * 4. if 1,2,3 is positive add user to request body
    * 5. if not, reset localstorage and headers
    * */


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }

}
