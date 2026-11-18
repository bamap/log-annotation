package ir.bamap.blu.log.annotation;

import ir.bamap.blu.log.enums.LogLevel;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@LogExecution(level = LogLevel.DEBUG)
public @interface DebugExecution {

    @AliasFor(annotation = LogExecution.class)
    int slowThresholdMs() default 200;

    /**
     * If contains `all` or `*`, it masks all arguments
     */
    @AliasFor(annotation = LogExecution.class)
    String[] maskArgs() default {};

    /**
     * If contains `all` or `*`, it ignores all arguments
     */
    @AliasFor(annotation = LogExecution.class)
    String[] ignoreArgs() default {};

    /**
     * If contains `all` or `*`, it masks all result fields
     */
    @AliasFor(annotation = LogExecution.class)
    String[] maskResultFields() default {};

    /**
     * If contains `all` or `*`, it ignores all result fields
     */
    @AliasFor(annotation = LogExecution.class)
    String[] ignoreResultFields() default {};
}
