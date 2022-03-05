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

internal class HeadersTest {

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