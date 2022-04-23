package dev.d1s.teabag.stdlib.ranges

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class RangesTest {

    @Test
    fun `should return valid int range`() {
        expectThat(
            "4..5".parseIntRange()
        ) isEqualTo 4..5
    }
}