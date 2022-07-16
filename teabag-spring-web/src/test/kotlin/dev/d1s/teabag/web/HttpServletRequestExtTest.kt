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

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import dev.d1s.teabag.testing.constant.INVALID_STUB
import dev.d1s.teabag.testing.constant.VALID_STUB
import javax.servlet.http.HttpServletRequest

internal class HttpServletRequestExtTest {

    private val request = mockk<HttpServletRequest> {
        every {
            getHeader(VALID_STUB)
        } returns VALID_STUB

        every {
            getHeader(INVALID_STUB)
        } returns null
    }

    @Test
    fun `should return HeadersAccessor`() {
        expectThat(request.headers).isA<HeadersAccessor>()
    }

    @Test
    fun `should return valid header`() {
        expectThat(request.headers[VALID_STUB]).isEqualTo(VALID_STUB)

        verify {
            request.getHeader(VALID_STUB)
        }
    }

    @Test
    fun `should return null`() {
        expectThat(request.headers[INVALID_STUB]).isEqualTo(null)

        verify {
            request.getHeader(INVALID_STUB)
        }
    }
}