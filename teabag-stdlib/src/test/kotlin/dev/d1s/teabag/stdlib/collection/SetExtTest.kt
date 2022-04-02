package dev.d1s.teabag.stdlib.collection

import dev.d1s.teabag.testing.constant.INVALID_STUB
import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly
import strikt.assertions.isA

internal class SetExtTest {

    @Test
    fun `should return valid mapped set`() {
        expectThat(
            setOf(INVALID_STUB).mapToSet {
                VALID_STUB
            }
        ) {
            isA<Set<String>>()
            containsExactly(VALID_STUB)
        }
    }
}