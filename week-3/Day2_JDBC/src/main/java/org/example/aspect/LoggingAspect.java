package org.example.aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "org.example")
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger("org.example.aspect.Loggable");


    @Around("@annotation(org.example.aspect.Loggable)")
    public Object log(ProceedingJoinPoint joinPoint )throws Throwable {
        String info=joinPoint.getSignature().getName();
        logger.info("delete starting");
        long start = System.currentTimeMillis();
        Object result  = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("deleting is successful and the time taken is " + (end-start)+" " +info);
        return result;

    }
}
