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

package dev.d1s.teabag.dto.util

import dev.d1s.teabag.dto.DtoListConverterFacade
import dev.d1s.teabag.dto.testUtil.mockDtoConverter
import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isNull

internal class DtoConverterExtTest {

    private val converter = mockDtoConverter()

    @Test
    fun `should return valid DtoListConverterFacade`() {
        expectThat(
            converter.converterForList()
        ).isA<DtoListConverterFacade<String, String>>()
    }

    @Test
    fun `should conditionally convert to dto and return valid one`() {
        expectThat(
            converter.convertToDtoIf(VALID_STUB, true)
        ) isEqualTo VALID_STUB
    }

    @Test
    fun `should conditionally convert to dto and return null`() {
        expectThat(
            converter.convertToDtoIf(VALID_STUB, false)
        ).isNull()
    }
}