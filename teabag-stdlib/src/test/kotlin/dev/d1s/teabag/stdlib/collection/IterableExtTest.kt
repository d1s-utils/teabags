package dev.d1s.teabag.stdlib.collection

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class IterableExtTest {

    @Test
    fun `should return true`() {
        expectThat(setOf(1, 2, 3) anyIn setOf(0, 5, 2)).isEqualTo(true)
    }

    @Test
    fun `should return false`() {
        expectThat(setOf(1, 2, 3) anyIn setOf(4, 5, 6)).isEqualTo(false)
    }

    @Test
    fun `should iterate over the collection and return the value calculated in the block`() {
        val string = "abc"

        expectThat(
            listOf("a", "b", "c").multiply(string) { it, principal ->
                principal.replace(it, "r")
            }
        ).isEqualTo("rrr")
    }
}