package dev.d1s.teabag.web

import dev.d1s.teabag.web.marker.TeabagWebDslMarker
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import org.springframework.web.util.UriComponentsBuilder

private const val X_FORWARDED_PROTO = "X-Forwarded-Proto"

@TeabagWebDslMarker
public inline fun <R> buildFromCurrentRequest(block: UriComponentsBuilder.() -> R): R =
    ServletUriComponentsBuilder.fromCurrentRequest().run(block)

public fun UriComponentsBuilder.configureSsl(fallbackToHttps: Boolean = false) {
    currentRequest.getHeader(X_FORWARDED_PROTO)?.let {
        scheme(it)
    } ?: run {
        if (fallbackToHttps) {
            scheme("https")
        }
    }
}