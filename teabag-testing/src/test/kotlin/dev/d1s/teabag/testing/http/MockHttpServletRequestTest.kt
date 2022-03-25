package dev.d1s.teabag.testing.http

import dev.d1s.teabag.testing.mockRequest
import org.junit.jupiter.api.Test
import org.springframework.mock.web.MockHttpServletRequest
import strikt.api.expectThat
import strikt.assertions.isA

internal class MockHttpServletRequestTest {

    @Test
    fun `should return MockHttpServletRequest`() {
        expectThat(mockRequest).isA<MockHttpServletRequest>()
    }
}