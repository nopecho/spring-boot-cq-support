package com.github.nopecho.spring.cqsupport.query;

/**
 * Query handler interface
 *
 * @param <R> result type
 */
public interface QueryHandler<R> {
    boolean canHandle(Query query);

    R handle(Query query);
}