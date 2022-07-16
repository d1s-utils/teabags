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

package dev.d1s.teabag.web.dto

import dev.d1s.teabag.testing.constant.VALID_STUB
import dev.d1s.teabag.testing.spring.web.http.mockRequest
import dev.d1s.teabag.web.currentRequest
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.time.Instant

internal class ErrorDtoTest {

    @Test
    fun `should assign valid default values`() {
        mockkStatic(Instant::class) {
            mockkStatic("dev.d1s.teabag.web.CurrentRequestKt") {
                every {
                    Instant.now()
                } returns Instant.EPOCH

                every {
                    currentRequest
                } returns mockRequest.apply {
                    requestURI = VALID_STUB
                }

                val error = ErrorDto()

                expectThat(error.timestamp).isEqualTo(Instant.EPOCH)
                expectThat(error.status).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value())
                expectThat(error.error).isEqualTo("Something went wrong.")
                expectThat(error.path).isEqualTo(VALID_STUB)
            }
        }
    }
}