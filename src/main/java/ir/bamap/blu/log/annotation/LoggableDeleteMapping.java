package ir.bamap.blu.log.annotation;

import ir.bamap.blu.log.enums.LogLevel;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@LogExecution
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.DELETE)
public @interface LoggableDeleteMapping {

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

    @AliasFor(annotation = RequestMapping.class)
    String name() default "";

    @AliasFor(annotation = RequestMapping.class)
    String[] value() default {};

    @AliasFor(annotation = RequestMapping.class)
    String[] path() default {};

    @AliasFor(annotation = RequestMapping.class)
    String[] params() default {};

    @AliasFor(annotation = RequestMapping.class)
    String[] headers() default {};

    @AliasFor(annotation = RequestMapping.class)
    String[] consumes() default {};

    @AliasFor(annotation = RequestMapping.class)
    String[] produces() default {};

}
