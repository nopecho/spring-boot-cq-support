package com.github.nopecho.spring.cqsupport.command;

/**
 * Command interface
 */
public interface Command {
    default <T extends Command> boolean is(Class<T> clazz) {
        return this.getClass().equals(clazz);
    }
}
