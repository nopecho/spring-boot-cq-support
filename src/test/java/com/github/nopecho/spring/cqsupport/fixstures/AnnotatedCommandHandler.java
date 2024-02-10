package com.github.nopecho.spring.cqsupport.fixstures;

import com.github.nopecho.spring.cqsupport.command.Command;
import com.github.nopecho.spring.cqsupport.command.CommandDispatch;
import com.github.nopecho.spring.cqsupport.command.CommandHandler;

@CommandDispatch
public class AnnotatedCommandHandler implements CommandHandler<Object> {

    @Override
    public boolean canHandle(Command command) {
        return command.is(AnnotatedCommand.class);
    }

    @Override
    public Object handle(Command command) {
        return null;
    }

    public record AnnotatedCommand() implements Command {
    }
}
