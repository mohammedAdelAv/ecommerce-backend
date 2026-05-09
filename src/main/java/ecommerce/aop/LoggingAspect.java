package ecommerce.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* ecommerce..*(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("Entering: "
                + joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "execution(* ecommerce..*(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("Exiting: "
                + joinPoint.getSignature().toShortString());

        System.out.println("Returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* ecommerce..*(..))",
            throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {

        System.out.println("Exception in: "
                + joinPoint.getSignature().toShortString());

        System.out.println("Error: " + exception.getMessage());
    }
}