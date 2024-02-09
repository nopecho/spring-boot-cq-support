package com.github.nopecho.spring.cqsupport;

import com.github.nopecho.spring.cqsupport.command.CommandDispatcher;
import com.github.nopecho.spring.cqsupport.command.CommandHandler;
import com.github.nopecho.spring.cqsupport.query.QueryDispatcher;
import com.github.nopecho.spring.cqsupport.query.QueryHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration(proxyBeanMethods = false)
public class CommandQueryDispatcherConfiguration {

    @Bean
    @ConditionalOnMissingBean(CommandDispatcher.class)
    public CommandDispatcher commandDispatcher(Set<CommandHandler<?>> handlers) {
        return new CommandDispatcher(handlers);
    }

    @Bean
    @ConditionalOnMissingBean(QueryDispatcher.class)
    public QueryDispatcher queryDispatcher(Set<QueryHandler<?>> handlers) {
        return new QueryDispatcher(handlers);
    }
}
