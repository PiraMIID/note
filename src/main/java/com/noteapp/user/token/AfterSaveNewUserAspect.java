//package com.noteapp.user.token;
//
//import com.noteapp.user.SinginRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.stereotype.Service;
//
//@Aspect
//@Slf4j
//@EnableAspectJAutoProxy
//@Service
//public class AfterSaveNewUserAspect {
//
//    private TokenService tokenService;
//
//    public AfterSaveNewUserAspect(TokenService tokenService) {
//        this.tokenService = tokenService;
//    }
//
//    @Pointcut("execution(* com.noteapp.user.AuthenticationController.save(..))")
//    void signupMethod() {
//    }
//
//
//    @After("signupMethod()")
//    void checkDataInBase(JoinPoint joinPoint) {
//        SinginRequest singinRequest = (SinginRequest) joinPoint.getArgs()[0];
//        String username = singinRequest.getUsername();
//        String email = singinRequest.getEmail();
//        System.out.println("CheckUsernameAndEmailAreNotUsed");
//        System.out.println(username);
//        System.out.println(email);
//    }
//}
