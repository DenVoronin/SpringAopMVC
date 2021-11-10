package cars;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


//2

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FuelExceptionHandler {

   @Aspect
    @Component
public class test1 {



       @Pointcut("@annotation(cars.FuelExceptionHandler)")
    public void test() {}
    @Around("test()")
    public void beforeAdvice(ProceedingJoinPoint joinPoint) {
        try {
            joinPoint.proceed();
            System.out.println("annotation for "+ joinPoint.toString());
        } catch (Throwable e) {
            System.out.print("Error");
        }
}

   }

}

