package dev.d1s.teabag.stdlib.checks

import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class AnyExtTest {

    @Test
    fun `should throw IllegalArgumentException if the object is null`() {
        val nullAny: Any? = null

        val exception = assertThrows<IllegalArgumentException> {
            nullAny.checkNotNull(VALID_STUB)
        }

        expectThat(exception.message) isEqualTo "$VALID_STUB must not be null."
    }
}