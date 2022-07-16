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

package dev.d1s.teabag.stdlib.exception

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class ExceptionTest {

    @Test
    fun `should throw IllegalStateException`() {
        val exception = assertThrows<IllegalStateException> {
            operationNotSupported()
        }

        expectThat(exception.message!!) isEqualTo "This operation is not supported."
    }
}