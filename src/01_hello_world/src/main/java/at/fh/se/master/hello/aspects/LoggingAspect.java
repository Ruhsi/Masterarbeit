package at.fh.se.master.hello.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(getClass());

    public LoggingAspect(){}

    @AfterReturning("execution(* at.fh.se.master.hello.controller..*.*(..))")
    public void logMethodAccessAfterReturning(JoinPoint jp){
        System.out.println("Starting........");
        log.info(" *** Completeted: " + jp.getSignature().getName() + " ***");
    }

    @Before("execution(* at.fh.se.master.hello.controller..*.*(..))")
    public void logMethodAccessBefore(JoinPoint jp){
        log.info(" *** Starting: " + jp.getSignature().getName() + " ***");
    }
}
