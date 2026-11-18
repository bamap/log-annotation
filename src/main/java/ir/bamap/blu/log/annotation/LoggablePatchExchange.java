package ir.bamap.blu.log.annotation;

import ir.bamap.blu.log.enums.LogLevel;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.service.annotation.HttpExchange;

import java.lang.annotation.*;

@Documented
@LogExecution
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@HttpExchange(method = "PATCH")
public @interface LoggablePatchExchange {

    @AliasFor(annotation = LogExecution.class)
    int slowThresholdMs() default 600;

    @AliasFor(annotation = LogExecution.class)
    LogLevel level() default LogLevel.INFO;

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

    @AliasFor(annotation = HttpExchange.class)
    String value() default "";

    @AliasFor(annotation = HttpExchange.class)
    String url() default "";

    @AliasFor(annotation = HttpExchange.class)
    String contentType() default "";

    @AliasFor(annotation = HttpExchange.class)
    String[] accept() default {};

    @AliasFor(annotation = HttpExchange.class)
    String[] headers() default {};

    @AliasFor(annotation = HttpExchange.class)
    String version() default "";
}
