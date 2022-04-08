package dev.d1s.teabag.stdlib.exception

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class ExceptionTest {

    @Test
    fun `should throw IllegalStateException`() {
        val exception = assertThrows<IllegalStateException> {
            operationNotSupported()
        }

        expectThat(exception.message!!) isEqualTo "This operation is not supported."
    }
}