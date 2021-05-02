package com.noteapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Service
@EnableAspectJAutoProxy
@Slf4j
public class GetUsernameBeforeEndpoinds {

    public static String username;

    @Pointcut("execution(* com.noteapp.*..*(..))")
    private void anyMethod() {
    }

    @Before(value = "anyMethod()")
    private String getusername(JoinPoint joinPoint) {
        if (!Arrays.stream(joinPoint.getArgs()).allMatch(Objects::nonNull) || joinPoint.getClass().isAssignableFrom(JpaRepository.class)) {
            username = SecurityContextHolder.getContext().getAuthentication().getName();
            System.out.println("GetUsernameBeforeEndpoinds username:" + username);
            return username;
        }
        return "";
    }
}
