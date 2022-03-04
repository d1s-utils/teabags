package uno.d1s.teabag.web

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest

public val currentRequest: HttpServletRequest
    get() = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request