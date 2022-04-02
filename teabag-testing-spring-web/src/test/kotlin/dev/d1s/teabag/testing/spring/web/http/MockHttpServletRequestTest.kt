package dev.d1s.teabag.testing.spring.web.http

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