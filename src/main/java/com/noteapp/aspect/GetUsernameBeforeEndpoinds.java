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
import java.util.Optional;

@Aspect
@Service
@EnableAspectJAutoProxy
public class GetUsernameBeforeEndpoinds {

    public String username;

    private static String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

//    todo: @Pointcut("execution(* com.noteapp.*..*(..))")
//    i can use also @Pointcut("execution(* com.noteapp.*..*(..) || sdgsdbedrfb && asfsd)")

//    next time after you will start thing about last problems
//    also what you learned e.g.c.
//    first i'm want faster. And this is the main reason that im slower
//    but i very good actually.
//    @Pointcut("execution(* com.noteapp.*..*(..))")
//    private void anyMethod() {
//    }
//
//    @Before(value = "anyMethod()")
//    private String getUsername(JoinPoint joinPoint) {
//        if (!Arrays.stream(joinPoint.getArgs()).allMatch(Objects::nonNull) || joinPoint.getClass().isAssignableFrom(JpaRepository.class)) {
//            username = SecurityContextHolder.getContext().getAuthentication().getName();
//            System.out.println("GetUsernameBeforeEndpoinds username:" + username);
//            return username;
//        }
//        return "";
//    }
}
