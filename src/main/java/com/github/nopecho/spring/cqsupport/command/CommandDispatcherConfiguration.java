package com.github.nopecho.spring.cqsupport.command;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class CommandDispatcherConfiguration {

    @Bean
    @ConditionalOnMissingBean(CommandDispatcher.class)
    public CommandDispatcher commandDispatcher(ApplicationContext context) {
        return new CommandDispatcher(commandHandlers(context));
    }

    @Bean
    public Set<CommandHandler<?>> commandHandlers(ApplicationContext context) {
        Set<CommandHandler<?>> handlers = new HashSet<>();

        context.getBeansOfType(CommandHandler.class).values().stream()
                .filter(handler -> handler.getClass().isAnnotationPresent(CommandDispatch.class))
                .forEach(handlers::add);

        return handlers;
    }
}
