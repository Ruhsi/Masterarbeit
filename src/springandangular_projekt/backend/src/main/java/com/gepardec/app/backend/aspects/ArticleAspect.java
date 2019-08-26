package com.gepardec.app.backend.aspects;

import com.gepardec.app.backend.controller.ArticleController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ArticleAspect {

    private final Logger log = LoggerFactory.getLogger(ArticleController.class);

    @Before("execution(* com.gepardec.app.backend.controller..*.*(..))")
    public void logMethodAccessBefore(JoinPoint jp){
        log.info(" *** Starting: " + jp.getSignature().getName() + " ***");
    }

    @AfterReturning("execution(* com.gepardec.app.backend.controller..*.*(..))")
    public void logMethodAccessAfterReturning(JoinPoint jp){
        log.info(" *** Completeted: " + jp.getSignature().getName() + " ***");
    }
}
