package at.fh.se.master.company.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public aspect LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* at.fh.se.master.company..*(..))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        // Get intercepted Method Details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        logger.info("Method called: " + className + "." + methodName);
        Object result = proceedingJoinPoint.proceed();
        logger.info("Finished Method: " + className + "." + methodName);

        return result;
    }
}
