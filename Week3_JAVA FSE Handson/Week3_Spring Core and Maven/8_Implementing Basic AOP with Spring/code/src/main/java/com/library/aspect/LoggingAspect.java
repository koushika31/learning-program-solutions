package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.displayBook(..))")
    public void beforeMethod() {
        System.out.println("[LOG] Before displaying book");
    }

    @After("execution(* com.library.service.BookService.displayBook(..))")
    public void afterMethod() {
        System.out.println("[LOG] After displaying book");
    }
}
