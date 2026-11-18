package ir.bamap.blu.log.annotation;

import ir.bamap.blu.log.enums.LogLevel;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface LogExecution {

    int slowThresholdMs() default 200;

    LogLevel level() default LogLevel.INFO;

    /**
     * If contains `all` or `*`, it masks all arguments
     */
    String[] maskArgs() default {};

    /**
     * If contains `all` or `*`, it ignores all arguments
     */
    String[] ignoreArgs() default {};

    /**
     * If contains `all` or `*`, it masks all result fields
     */
    String[] maskResultFields() default {};

    /**
     * If contains `all` or `*`, it ignores all result fields
     */
    String[] ignoreResultFields() default {};
}
