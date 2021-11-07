package cars;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



//2
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface FuelExceptionHandler {
    @Aspect
    @Component
public class test1{
    @Pointcut("execution(* Controller.checkFuel(String))")
    public void test() {}
    @Around("test()")
    public void beforeAdvice(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.print("This type of engine not aviable ");
        }

    }
} }