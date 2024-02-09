package com.github.nopecho.spring.cqsupport.command;

/**
 * Command handler interface
 *
 * @param <R> result type
 */
public interface CommandHandler<R> {
    boolean canHandle(Command command);

    R handle(Command command);
}