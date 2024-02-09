package com.github.nopecho.spring.cqsupport.query;

/**
 * Query interface
 */
public interface Query {
    default boolean is(Class<Query> clazz) {
        return this.getClass().equals(clazz);
    }
}
