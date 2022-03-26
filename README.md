[![](https://jitpack.io/v/d1snin/teabags.svg)](https://jitpack.io/#d1snin/teabags)

# teabags

Teabags are utilities for Spring modules and other libraries including standard one, which makes the code more fluent,
pretty and simple to understand.

### Installation

```kotlin
repositories {
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("dev.d1s.teabags:{module}:{teabags version}")
}
```

### Modules

| Module                  | Description                                |
|-------------------------|--------------------------------------------|
| `teabag-mapstruct`      | Utilities for mapstruct's `Mappers`.       |
| `teabag-slf4j`          | Utilities for for `slf4j-api`.             |
| `teabag-spring-web`     | Utilities for Spring Web.                  |
| `teabag-stdlib`         | Utilities for Kotlin/JVM standard library. |
| `teabag-testing`        | Utilities for testing.                     |
| `teabag-testing-spring` | Utilities for testing Spring projects.     |
