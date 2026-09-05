# Log Annotation
A lightweight Java library providing declarative, annotation-driven logging for Spring applications. 
It offers drop-in replacements for standard Spring MVC (`@GetMapping`, `@PostMapping`, etc.) 
and Spring HTTP Interface (`@GetExchange`, `@PostExchange`, etc.) annotations that 
automatically log request/response details, execution time, and slow-operation warnings.

## Key Features
 - Zero-Boilerplate Logging: Annotate controller methods or service classes to enable structured logging instantly.
 - Spring Native: Meta-annotated with @RequestMapping and @HttpExchange—works as a direct replacement for @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping and their *Exchange counterparts.
 - Configurable Thresholds: Define slowThresholdMs per endpoint or class to automatically flag performance bottlenecks.
- Log Level Control: Supports DEBUG, INFO, WARN, ERROR levels via the LogLevel enum.
 - Dual Support: Covers both Server-side (Spring MVC) and Client-side (Spring HTTP Interfaces/Web Fluent) scenarios.
 - Utility Annotations: Includes @LogExecution (class/method level) and @DebugExecution for non-HTTP business logic tracing.

## Annotations Provided
| **Category** | **Annotations** |
|---|---|
| **Spring MVC (Server)** | `@LoggableGetMapping`, `@LoggablePostMapping`, `@LoggablePutMapping`, `@LoggablePatchMapping`, `@LoggableDeleteMapping` |
| **Spring HTTP Interface (Client)** | `@LoggableGetExchange`, `@LoggablePostExchange`, `@LoggablePutExchange`, `@LoggablePatchExchange`, `@LoggableDeleteExchange` |
| **Generic Execution** | `@LogExecution` (Type/Method), `@DebugExecution` (Method) |

## Quick Start
### 1. Add Dependency

```xml
<dependency>
    <groupId>ir.bamap.blu</groupId>
    <artifactId>log-annotation</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 2. Replace Standard Annotations
```java
@RestController
@RequiredArgsConstructor
public class UserController {

    // Logs at DEBUG level, warns if > 600ms
    @LoggableGetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) { ... }

    // Logs at INFO level, warns if > 1000ms
    @LoggablePostMapping(value = "/user", slowThresholdMs = 1000)
    public User createUser(@RequestBody UserDto dto) { ... }
}
```

### 3. Enable Aspect(Required) 
Ensure you have an AspectJ `@Aspect` (in your application codebase) that intercepts @Loggable... and `@LogExecution`
annotations to perform the actual logging logic (MDC population, request/response body capture, duration calculation).

## Configuration

| **Attribute** | **Default** | **Description** |
|---|---|---|
| **`level()`** | **`DEBUG`** (Get), **`INFO`** (Others) | Log severity level. |
| **`slowThresholdMs()`** | **`600`** (HTTP), **`200`** (Execution) | Threshold in ms to log a **"SLOW"** warning. |
| **`value()`**, **`path()`**, **`params()`**... | Standard Spring Mapping | All standard **`@RequestMapping`** / **`@HttpExchange`** attributes are supported via **`@AliasFor`**. |

## Requirements
 - Java 21+
- Spring Framework 6+ / Spring Boot 3+
- AspectJ Weaver (for runtime weaving of the logging aspect)