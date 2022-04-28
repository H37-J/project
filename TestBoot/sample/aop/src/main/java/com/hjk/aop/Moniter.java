package com.hjk.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

@Aspect
@Component
public class Moniter {
    
    @AfterReturning("execution(* com.hjk.aop.*Service.*(..))")
    public void logServiceAccess(JoinPoint joinPoint){
        System.out.println("Completed" + joinPoint);
    }
}
