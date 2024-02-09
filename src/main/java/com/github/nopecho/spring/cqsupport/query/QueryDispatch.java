package com.github.nopecho.spring.cqsupport.query;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Query dispatch annotation
 * <p>
 * used to mark classes that contain query dispatch
 * <p>
 * AutoConfiguration will scan for classes annotated with this annotation and register them as query dispatch
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryDispatch {
}
