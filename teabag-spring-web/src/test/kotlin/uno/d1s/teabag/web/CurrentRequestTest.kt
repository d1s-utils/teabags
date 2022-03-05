package uno.d1s.teabag.web

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import uno.d1s.teabag.testing.mockRequest

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

