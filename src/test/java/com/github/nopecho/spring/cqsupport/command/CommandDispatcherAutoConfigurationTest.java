package com.github.nopecho.spring.cqsupport.command;

import com.github.nopecho.spring.cqsupport.TestComponentScanConfig;
import com.github.nopecho.spring.cqsupport.fixstures.AnnotatedCommandHandler;
import com.github.nopecho.spring.cqsupport.fixstures.NotAnnotatedCommandHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {
        TestComponentScanConfig.class,
        ApplicationContext.class,
        CommandDispatcherAutoConfiguration.class
})
class CommandDispatcherAutoConfigurationTest {

    @Autowired
    private CommandDispatcherAutoConfiguration commandDispatcherAutoConfiguration;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void assertNotNullCommandDispatcherAutoConfiguration() {
        assertNotNull(commandDispatcherAutoConfiguration);
    }

    @Test
    void annotatedHandlerTest() {
        CommandDispatcher sut = applicationContext.getBean(CommandDispatcher.class);
        Command command = new AnnotatedCommandHandler.AnnotatedCommand();

        boolean actual = sut.isSupported(command);

        assertThat(actual).isTrue();
    }

    @Test
    void notAnnotatedHandlerTest() {
        CommandDispatcher sut = applicationContext.getBean(CommandDispatcher.class);
        Command command = new NotAnnotatedCommandHandler.NotAnnotatedCommand();

        boolean actual = sut.isSupported(command);

        assertThat(actual).isFalse();
    }
}