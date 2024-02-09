package com.github.nopecho.spring.cqsupport.command;

import java.util.NoSuchElementException;
import java.util.Set;

public class CommandDispatcher {

    private final Set<CommandHandler<?>> handlers;

    public CommandDispatcher(Set<CommandHandler<?>> handlers) {
        this.handlers = handlers;
    }

    public <T> T dispatch(Command command, Class<T> returnType) {
        CommandHandler<?> commandHandler = handlers.stream()
                .filter(handler -> handler.canHandle(command))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

        Object result = commandHandler.handle(command);
        return returnType.cast(result);
    }
}