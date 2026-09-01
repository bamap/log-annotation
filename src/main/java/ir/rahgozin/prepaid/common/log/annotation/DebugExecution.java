package ir.rahgozin.prepaid.common.log.annotation;

import ir.rahgozin.prepaid.common.log.enums.LogLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@LogExecution(level = LogLevel.DEBUG)
public @interface DebugExecution {

    int slowThresholdMs() default 200;
}
