package dev.d1s.teabag.testing.spring.http

import org.springframework.mock.web.MockHttpServletResponse

public val mockResponse: MockHttpServletResponse
    get() = MockHttpServletResponse()