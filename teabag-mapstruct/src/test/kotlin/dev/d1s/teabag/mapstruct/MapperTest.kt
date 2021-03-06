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

package dev.d1s.teabag.mapstruct

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class MapperTest {

    @Test
    fun `should return valid mapper`() {
        mockkStatic(Mappers::class) {
            val any = Any()

            every {
                Mappers.getMapper(Any::class.java)
            } returns any

            expectThat(getMapper<Any>()) isEqualTo any

            verify {
                Mappers.getMapper(Any::class.java)
            }
        }
    }
}