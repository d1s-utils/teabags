package dev.d1s.teabag.logging

import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA

internal class LoggerTest {

    @Test
    fun `should return Logger`() {
        expectThat(logger).isA<Logger>()
    }
}