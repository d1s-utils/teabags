package dev.d1s.teabag.testing.spring.web.http

import org.springframework.mock.web.MockHttpServletRequest

public val mockRequest: MockHttpServletRequest
    get() = MockHttpServletRequest()