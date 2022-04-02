package dev.d1s.teabag.data

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly

internal class ListExtTest {

    @Test
    fun `should return valid page`() {
        val list = listOf(1, 2, 3, 4, 5)

        // (index: content): 0: 1, 2; 1: 3, 4; 2: 5
        val page = list.toPage(1, 2)

        expectThat(page).containsExactly(3, 4)
    }
}