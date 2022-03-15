package dev.d1s.teabag.web

import dev.d1s.teabag.web.marker.TeabagWebDslMarker
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import org.springframework.web.util.UriComponentsBuilder

public fun buildFromCurrentRequest(): UriComponentsBuilder = ServletUriComponentsBuilder.fromCurrentRequest()

@TeabagWebDslMarker
public inline fun buildFromCurrentRequest(block: UriComponentsBuilder.() -> Unit): String =
    buildFromCurrentRequest().apply(block).toUriString()

public fun appendPath(value: String, includeScheme: Boolean = true, replaceHttpWithHttps: Boolean = true): String =
    buildFromCurrentRequest()
        .path("/{value}")
        .configureScheme(includeScheme, replaceHttpWithHttps)
        .buildAndExpand(value)
        .toUriString()

public fun appendRootPath(value: String, includeScheme: Boolean = true, replaceHttpWithHttps: Boolean = true): String =
    buildFromCurrentRequest()
        .configureScheme(includeScheme, replaceHttpWithHttps)
        .replacePath(null)
        .path(value)
        .toUriString()

public fun currentUriWithNoPath(includeScheme: Boolean = true, replaceHttpWithHttps: Boolean = true): String =
    buildFromCurrentRequest()
        .replacePath(null)
        .configureScheme(includeScheme, replaceHttpWithHttps)
        .toUriString()

private fun UriComponentsBuilder.configureScheme(includeScheme: Boolean, replaceHttpWithHttps: Boolean) = apply {
    if (!includeScheme) {
        scheme(null)
    } else {
        if (replaceHttpWithHttps) {
            scheme("https")
        }
    }
}
