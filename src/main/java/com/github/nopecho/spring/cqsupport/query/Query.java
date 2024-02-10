package com.github.nopecho.spring.cqsupport.query;

/**
 * Query interface
 */
public interface Query {
    default <T extends Query> boolean is(Class<T> clazz) {
        return this.getClass().equals(clazz);
    }
}
