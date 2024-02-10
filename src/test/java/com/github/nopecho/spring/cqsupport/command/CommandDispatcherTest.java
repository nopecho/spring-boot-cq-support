package com.github.nopecho.spring.cqsupport.command;

import com.github.nopecho.spring.cqsupport.fixstures.AnnotatedCommandHandler;
import com.github.nopecho.spring.cqsupport.fixstures.NotAnnotatedCommandHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class CommandDispatcherTest {

    private CommandDispatcher sut;

    private Set<CommandHandler<?>> handlers;

    @AfterEach
    void tearDown() {
        sut = null;
        handlers = null;
    }

    @Test
    void isSupportedTest() {
        handlers = Set.of(new AnnotatedCommandHandler());
        sut = new CommandDispatcher(handlers);
        Command command = new AnnotatedCommandHandler.AnnotatedCommand();

        boolean actual = sut.isSupported(command);

        assertThat(actual).isTrue();
    }

    @ParameterizedTest(name = "handlers: {0}, command: {1}")
    @MethodSource("notSupportedSource")
    void notSupportedTest(Set<CommandHandler<?>> handlers, Command command) {
        sut = new CommandDispatcher(handlers);

        boolean actual = sut.isSupported(command);

        assertThat(actual).isFalse();
    }

    static Stream<Arguments> notSupportedSource() {
        return Stream.of(
                of(
                        Set.of(),
                        new AnnotatedCommandHandler.AnnotatedCommand()
                ),
                of(
                        Set.of(),
                        null
                ),
                of(
                        Set.of(new AnnotatedCommandHandler()),
                        new NotAnnotatedCommandHandler.NotAnnotatedCommand()
                )
        );
    }
}