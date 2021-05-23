package com.noteapp.user.token;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@Aspect
@Slf4j
@EnableAspectJAutoProxy
@Service
public class AfterSaveNewUserAspect {

    private TokenService tokenService;

    public AfterSaveNewUserAspect(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Pointcut("execution(* com.noteapp.user.token.SignupController.confirmToken(..))")
    void signupMethod() {
    }

//  todo: thing to how use this aspect cause i want min one on the project
    @After("signupMethod()")
    void checkDataInBase(JoinPoint joinPoint) {
        System.out.println(joinPoint.getArgs()[0]);
        System.out.println("New user confirm account");
    }
}
