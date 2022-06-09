package dev.d1s.teabag.stdlib.collection

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isTrue

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

    @Test
    fun `should return space delimited string`() {
        expectThat(setOf("a", "b", "c").toSpaceDelimitedString()) isEqualTo "a b c"
    }

    @Test
    fun `should return lengthiest line`() {
        expectThat(listOf("-", "--").lengthiestLine()) isEqualTo "--"
    }

    @Test
    fun `should return set with transformed values`() {
        expectThat(
            listOf(1, 2, 3).mapToSet {
                it.toString()
            }
        ).containsExactly("1", "2", "3")
    }

    @Test
    fun `should return mutable set with transformed values`() {
        expectThat(
            listOf(1, 2, 3).mapToMutableSet {
                it.toString()
            }
        ).containsExactly("1", "2", "3")
    }

    @Test
    fun `should return true when calling hasDuplicates`() {
        expectThat(
            listOf(3, 2, 3).hasDuplicates()
        ).isTrue()
    }

    @Test
    fun `should return false when calling hasDuplicates`() {
        expectThat(
            listOf(1, 2, 3).hasDuplicates()
        ).isFalse()
    }

    @Test
    fun `should return true when calling hasDuplicatesBy`() {
        expectThat(
            listOf(
                Wrapper(3),
                Wrapper(2),
                Wrapper(3)
            ).hasDuplicatesOf {
                it.value
            }
        ).isTrue()
    }

    @Test
    fun `should return false when calling hasDuplicatesOf`() {
        expectThat(
            listOf(
                Wrapper(3),
                Wrapper(2),
                Wrapper(1)
            ).hasDuplicatesOf {
                it.value
            }
        ).isFalse()
    }

    private class Wrapper(val value: Int)
}