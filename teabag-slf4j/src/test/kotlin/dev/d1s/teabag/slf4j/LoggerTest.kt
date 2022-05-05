package dev.d1s.teabag.slf4j

import org.junit.jupiter.api.Test
import org.slf4j.Logger
import strikt.api.expectThat
import strikt.assertions.isA

internal class LoggerTest {

    @Test
    fun `should return Logger`() {
        expectThat(logger(this::class)).isA<Logger>()
    }
}