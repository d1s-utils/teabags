package dev.d1s.teabag.testing.spring.http

import org.springframework.mock.web.MockHttpServletRequest

public val mockRequest: MockHttpServletRequest
    get() = MockHttpServletRequest()