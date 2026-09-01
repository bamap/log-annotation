package ir.bamap.blu.log.annotation;

import ir.bamap.blu.log.enums.LogLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface LogExecution {

    int slowThresholdMs() default 200;

    LogLevel level() default LogLevel.INFO;
}
