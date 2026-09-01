package ir.bamap.blu.log.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.service.annotation.HttpExchange;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@HttpExchange(method = "PUT")
public @interface LoggablePutExchange {

    int slowThresholdMs() default 600;

    LogLevel level() default LogLevel.INFO;

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
