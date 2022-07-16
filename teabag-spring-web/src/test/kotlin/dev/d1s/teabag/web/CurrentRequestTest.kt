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

import dev.d1s.teabag.testing.spring.web.http.mockRequest
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class CurrentRequestTest {

    private val request = mockRequest

    @Test
    fun `should return current request`() {
        mockkStatic(RequestContextHolder::class) {
            every {
                (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
            } returns request

            expectThat(currentRequest).isEqualTo(request)

            verify {
                (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
            }
        }
    }

    @Test
    fun `should throw IllegalStateException if there are no request attributes`() {
        mockkStatic(RequestContextHolder::class) {
            every {
                RequestContextHolder.getRequestAttributes()
            } returns null

            assertThrows<IllegalStateException> {
                currentRequest
            }

            verify {
                RequestContextHolder.getRequestAttributes()
            }
        }
    }
}

