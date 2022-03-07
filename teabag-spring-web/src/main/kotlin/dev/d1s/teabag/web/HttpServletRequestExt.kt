package dev.d1s.teabag.web

import javax.servlet.http.HttpServletRequest

public val HttpServletRequest.headers: HeadersAccessor
    get() = HeadersAccessor(this)

public class HeadersAccessor(private val request: HttpServletRequest) {

    public operator fun get(key: String): String? = request.getHeader(key)
}