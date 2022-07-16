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