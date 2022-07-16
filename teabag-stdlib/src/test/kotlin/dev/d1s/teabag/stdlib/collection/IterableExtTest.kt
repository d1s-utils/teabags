/*
 * Copyright 2022 Teabags project contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        expectThat(listOf(1, 2, 3) anyIn listOf(0, 5, 2)).isEqualTo(true)
    }

    @Test
    fun `should return false`() {
        expectThat(listOf(1, 2, 3) anyIn listOf(4, 5, 6)).isEqualTo(false)
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
        expectThat(listOf("a", "b", "c").toSpaceDelimitedString()) isEqualTo "a b c"
    }

    @Test
    fun `should return lengthiest line`() {
        expectThat(listOf("-", "--").lengthiestLine()) isEqualTo "--"
    }

    @Test
    fun `should return mutable list with transformed values`() {
        expectThat(
            listOf(1, 2, 3).mapToMutableList {
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