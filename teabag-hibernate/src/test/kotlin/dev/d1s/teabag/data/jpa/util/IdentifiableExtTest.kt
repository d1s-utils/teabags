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

package dev.d1s.teabag.data.jpa.util

import dev.d1s.teabag.data.jpa.Identifiable
import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import strikt.api.expectThat
import strikt.assertions.containsExactly

internal class IdentifiableExtTest {

    @Test
    fun `should map to id list`() {
        expectThat(
            identifiableList.mapToIdList()
        ).containsExactly(VALID_STUB)
    }

    @Test
    fun `should map to not null id list`() {
        expectThat(
            identifiableList.mapToNotNullIdList()
        ).containsExactly(VALID_STUB)
    }

    @Test
    fun `should throw IllegalArgumentException when mapping to not null id list`() {
        assertThrows<IllegalArgumentException> {
            (identifiableList + object : Identifiable() {}).mapToNotNullIdList()
        }
    }

    private companion object {

        private val identifiableList = listOf(
            object : Identifiable() {}.apply {
                id = VALID_STUB
            }
        )
    }
}