package com.github.nopecho.spring.cqsupport.query;

import java.util.NoSuchElementException;
import java.util.Set;

public class QueryDispatcher {

    private final Set<QueryHandler<?>> handlers;

    public QueryDispatcher(Set<QueryHandler<?>> handlers) {
        this.handlers = handlers;
    }

    public <R> R dispatch(Query query, Class<R> returnType) {
        QueryHandler<?> queryHandler = handlers.stream()
                .filter(handler -> handler.canHandle(query))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        Object result = queryHandler.handle(query);
        return returnType.cast(result);
    }

    public boolean isSupported(Query query) {
        return handlers.stream()
                .anyMatch(handler -> handler.canHandle(query));
    }
}
