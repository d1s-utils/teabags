package dev.d1s.teabag.logging

import org.junit.jupiter.api.Test
import org.slf4j.Logger
import strikt.api.expectThat
import strikt.assertions.isA

internal class LoggerTest {

    @Test
    fun `should return Logger`() {
        expectThat(logger).isA<Logger>()
    }
}