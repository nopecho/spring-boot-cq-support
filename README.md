# Spring Boot C/Q Support

[![](https://jitpack.io/v/nopecho/spring-boot-cq-support.svg)](https://jitpack.io/#nopecho/spring-boot-cq-support)

## Getting Started

```groovy
// build.gradle

repositories {
    mavenCentral()
    maven { url "https://jitpack.io" }
}
dependencies {
    implementation 'com.github.nopecho:spring-boot-cq-support:0.0.2'
}
```

## How to use

### 1. Create Command

```kotlin
data class FooCommand(
    val foo: String? = null
) : Command
```

### 2. Implementation Command Handler

```kotlin
/**
 * Auto register as Bean
 * (extends @Component annotation)
 */
@CommandDispatch
class FooCommandHandler : CommandHandler<Any> {

    override fun canHandle(command: Command?): Boolean {
        return command is FooCommand
    }

    override fun handle(command: Command?): Any {
        val fooCommand = command as FooCommand
        // logic
        return "do something.. $fooCommand"
    }
}
```

### 3. Use Command Dispatcher

```kotlin
@RestController
class CommandController(
    private val dispatcher: CommandDispatcher
) {
    @PostMapping("/commands")
    fun handleCommand(): Any {
        val command = FooCommand()
        return dispatcher.dispatch(command, Any::class.java)
    }
}
```
