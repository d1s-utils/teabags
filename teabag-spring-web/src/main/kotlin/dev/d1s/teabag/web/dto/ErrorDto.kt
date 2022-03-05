package dev.d1s.teabag.web.dto

import dev.d1s.teabag.web.currentRequest
import org.springframework.http.HttpStatus
import java.time.Instant

public data class ErrorDto(
    var timestamp: Instant = Instant.now(),
    var status: Int = HttpStatus.INTERNAL_SERVER_ERROR.value(),
    var error: String = "Something went wrong.",
    var path: String = currentRequest.pathInfo ?: "/"
)