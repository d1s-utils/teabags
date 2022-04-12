package dev.d1s.teabag.stdlib.collection

import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class MapsTest {

    @Test
    fun `should return map of not null values`() {
        expectThat(
            mapOfNotNullValues(
                VALID_STUB to null
            )
        ) isEqualTo mapOf()
    }
}