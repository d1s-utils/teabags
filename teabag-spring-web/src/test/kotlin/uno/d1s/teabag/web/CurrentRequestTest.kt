package uno.d1s.teabag.web

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import uno.d1s.teabag.testing.mockRequest

internal class CurrentRequestTest {

    @Test
    fun `should return current request`() {
        mockkStatic(RequestContextHolder::class) {
            every {
                (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
            } returns mockRequest

            expectThat(currentRequest).isEqualTo(mockRequest)

            verify {
                (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
            }
        }
    }
}

