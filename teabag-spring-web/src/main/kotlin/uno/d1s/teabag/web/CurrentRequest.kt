package uno.d1s.teabag.web

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest

public val currentRequest: HttpServletRequest
    get() = ((RequestContextHolder.getRequestAttributes()
        ?: throw IllegalStateException("No request attributes were bound."))
            as ServletRequestAttributes).request