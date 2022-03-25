package dev.d1s.teabag.testing

import org.springframework.mock.web.MockHttpServletRequest

public val mockRequest: MockHttpServletRequest
    get() = MockHttpServletRequest()