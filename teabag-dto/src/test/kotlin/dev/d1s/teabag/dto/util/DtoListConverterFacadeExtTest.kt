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

import dev.d1s.teabag.dto.testUtil.mockDtoConverter
import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isNull

internal class DtoListConverterFacadeExtTest {

    private val dtoListConverterFacade =
        mockDtoConverter().converterForList()

    @Test
    fun `should conditionally convert to dto and return valid one`() {
        expectThat(
            dtoListConverterFacade.convertToDtoListIf(
                listOf(VALID_STUB),
                true
            )
        ) isEqualTo listOf(VALID_STUB)
    }

    @Test
    fun `should conditionally convert to dto and return null`() {
        expectThat(
            dtoListConverterFacade.convertToDtoListIf(
                listOf(VALID_STUB),
                false
            )
        ).isNull()
    }
}