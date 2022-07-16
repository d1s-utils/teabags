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

package dev.d1s.teabag.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import dev.d1s.teabag.testing.constant.VALID_STUB
import dev.d1s.teabag.testing.spring.web.http.mockRequest
import dev.d1s.teabag.testing.spring.web.http.mockResponse
import dev.d1s.teabag.web.dto.ErrorDto
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.time.Instant

internal class HttpServletResponseExtTest {

    private val response = spyk(mockResponse)

    private val testErrorDto = ErrorDto(
        Instant.EPOCH,
        HttpStatus.BAD_REQUEST.value(),
        VALID_STUB,
        VALID_STUB
    )

    private val objectMapper = ObjectMapper().registerModule(JavaTimeModule())

    @Test
    fun `should send error`() {
        mockkStatic("dev.d1s.teabag.web.CurrentRequestKt") {
            every {
                currentRequest
            } returns mockRequest

            val content = objectMapper.writeValueAsString(testErrorDto)

            response.sendErrorDto {
                timestamp = testErrorDto.timestamp
                status = testErrorDto.status
                error = testErrorDto.error
                path = testErrorDto.path
            }

            expectThat(response.contentType).isEqualTo(MediaType.APPLICATION_JSON_VALUE)
            expectThat(response.status).isEqualTo(testErrorDto.status)
            expectThat(response.contentAsString).isEqualTo(content)

            verify {
                response.contentType = MediaType.APPLICATION_JSON_VALUE
            }

            verify {
                response.status = testErrorDto.status
            }
        }
    }
}