package ir.rahgozin.prepaid.common.log.annotation;

import ir.rahgozin.prepaid.common.log.enums.LogLevel;

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
