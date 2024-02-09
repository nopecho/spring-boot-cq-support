package com.github.nopecho.spring.cqsupport.command;

/**
 * Command interface
 */
public interface Command {
    default boolean is(Class<Command> clazz) {
        return this.getClass().equals(clazz);
    }
}
