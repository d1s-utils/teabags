package dev.d1s.teabag.testing.spring.web.http

import org.junit.jupiter.api.Test
import org.springframework.mock.web.MockHttpServletResponse
import strikt.api.expectThat
import strikt.assertions.isA

internal class MockHttpServletResponseTest {

    @Test
    fun `should return MockHttpServletResponse`() {
        expectThat(mockResponse).isA<MockHttpServletResponse>()
    }
}