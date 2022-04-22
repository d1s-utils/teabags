package dev.d1s.teabag.web

import dev.d1s.teabag.testing.constant.VALID_STUB
import dev.d1s.teabag.testing.spring.web.http.mockRequest
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

internal class ServletUriComponentsBuilderTest {

    @Test
    fun `should build the uri`() {
        this.withStaticMocks {
            buildFromCurrentRequest {
                configureSsl()
            }

            verify {
                it.scheme(VALID_STUB)
            }
        }
    }

    @Test
    fun `should fallback to https`() {
        this.withStaticMocks {
            every {
                currentRequest
            } returns mockRequest

            buildFromCurrentRequest {
                configureSsl(true)
            }

            verify {
                it.scheme("https")
            }
        }
    }

    private inline fun withStaticMocks(block: (ServletUriComponentsBuilder) -> Unit) {
        mockkStatic("org.springframework.web.servlet.support.ServletUriComponentsBuilder") {
            val builder = mockk<ServletUriComponentsBuilder> {
                every {
                    scheme(any())
                } returns this
            }

            every {
                ServletUriComponentsBuilder.fromCurrentRequest()
            } returns builder

            mockkStatic("dev.d1s.teabag.web.CurrentRequestKt") {
                every {
                    currentRequest
                } returns mockRequest.apply {
                    addHeader("X-Forwarded-Proto", VALID_STUB)
                }

                block(builder)
            }
        }
    }
}