package com.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.demo")
@Aspect
public class LoggableAspect {
    private Logger logger = LoggerFactory.getLogger("com.demo.aspect.LoggableAspect");


    @Around("@annotation(com.demo.logapp.Loggable)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String info = joinPoint.getSignature().getName();
        logger.info("account transfer is initiated");
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("transfer is successful and the time taken is " + (end - start) + " " + info);
        return result;
    }
}
