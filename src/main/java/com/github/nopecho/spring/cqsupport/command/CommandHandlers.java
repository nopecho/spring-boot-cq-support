package com.github.nopecho.spring.cqsupport.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Command handlers annotation
 * <p>
 * used to mark classes that contain command handlers
 * <p>
 * AutoConfiguration will scan for classes annotated with this annotation and register them as command handlers
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandHandlers {
}
