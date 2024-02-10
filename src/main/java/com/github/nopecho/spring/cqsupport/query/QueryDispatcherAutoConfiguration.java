package com.github.nopecho.spring.cqsupport.query;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@AutoConfiguration
@Configuration
public class QueryDispatcherAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(QueryDispatcher.class)
    public QueryDispatcher queryDispatcher(ApplicationContext context) {
        return new QueryDispatcher(queryHandlers(context));
    }

    @Bean
    public Set<QueryHandler<?>> queryHandlers(ApplicationContext context) {
        Set<QueryHandler<?>> handlers = new HashSet<>();

        context.getBeansOfType(QueryHandler.class).values().stream()
                .filter(handler -> handler.getClass().isAnnotationPresent(QueryDispatch.class))
                .forEach(handlers::add);

        return handlers;
    }
}
