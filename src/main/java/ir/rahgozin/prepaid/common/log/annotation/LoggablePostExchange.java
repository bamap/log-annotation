package ir.rahgozin.prepaid.common.log.annotation;

import ir.rahgozin.prepaid.common.log.enums.LogLevel;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.service.annotation.HttpExchange;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@HttpExchange(
        method = "POST"
)
public @interface LoggablePostExchange {

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
