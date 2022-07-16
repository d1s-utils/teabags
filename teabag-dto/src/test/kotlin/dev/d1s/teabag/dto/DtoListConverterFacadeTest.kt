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

package dev.d1s.teabag.dto

import dev.d1s.teabag.dto.testUtil.mockDtoConverter
import dev.d1s.teabag.testing.constant.INVALID_STUB
import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly
import strikt.assertions.isA

internal class DtoListConverterFacadeTest {

    private val facade = DtoListConverterFacade(
        mockDtoConverter()
    )

    @Test
    fun `should return valid list of dtos`() {
        expectThat(
            facade.convertToDtoList(
                listOf(INVALID_STUB)
            )
        ) {
            isA<List<String>>()
            containsExactly(VALID_STUB)
        }
    }

    @Test
    fun `should return valid list of entities`() {
        expectThat(
            facade.convertToEntityList(
                listOf(VALID_STUB)
            )
        ) {
            isA<List<String>>()
            containsExactly(INVALID_STUB)
        }
    }
}