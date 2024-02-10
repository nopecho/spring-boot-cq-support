package com.github.nopecho.spring.cqsupport.fixstures;

import com.github.nopecho.spring.cqsupport.command.Command;
import com.github.nopecho.spring.cqsupport.command.CommandHandler;

public class NotAnnotatedCommandHandler implements CommandHandler<Object> {

    @Override
    public boolean canHandle(Command command) {
        return command.is(NotAnnotatedCommand.class);
    }

    @Override
    public Object handle(Command command) {
        return null;
    }

    public record NotAnnotatedCommand() implements Command {
    }
}
