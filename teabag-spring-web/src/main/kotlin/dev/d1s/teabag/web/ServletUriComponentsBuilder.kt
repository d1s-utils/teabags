package dev.d1s.teabag.web

import dev.d1s.teabag.web.marker.TeabagWebDslMarker
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

public fun buildFromCurrentRequest(): UriComponentsBuilder = ServletUriComponentsBuilder.fromCurrentRequest()

@TeabagWebDslMarker
public inline fun buildFromCurrentRequest(block: UriComponentsBuilder.() -> Unit): String =
    buildFromCurrentRequest().apply(block).toUriString()

public fun appendPath(
    value: String,
    includeScheme: Boolean = true,
    replaceHttpWithHttps: Boolean = true,
    keepParameters: Boolean = false,
    encode: Boolean = false
): String = buildFromCurrentRequest()
    .configureScheme(includeScheme, replaceHttpWithHttps)
    .configureParameters(keepParameters)
    .path(value)
    .toUriString(encode)

public fun appendUri(
    value: String,
    includeScheme: Boolean = true,
    replaceHttpWithHttps: Boolean = true,
    keepParameters: Boolean = false,
): URI = buildFromCurrentRequest()
    .configureScheme(includeScheme, replaceHttpWithHttps)
    .configureParameters(keepParameters)
    .path("{value}")
    .build(value)

public fun appendRootPath(
    value: String, includeScheme: Boolean = true,
    replaceHttpWithHttps: Boolean = true,
    keepParameters: Boolean = false,
    encode: Boolean = false
): String = buildFromCurrentRequest()
    .configureScheme(includeScheme, replaceHttpWithHttps)
    .configureParameters(keepParameters)
    .replacePath(null)
    .path(value)
    .toUriString(encode)

public fun currentUriWithNoPath(
    includeScheme: Boolean = true,
    replaceHttpWithHttps: Boolean = true,
    keepParameters: Boolean = false,
    encode: Boolean = false
): String = buildFromCurrentRequest()
    .configureScheme(includeScheme, replaceHttpWithHttps)
    .configureParameters(keepParameters)
    .replacePath(null)
    .toUriString(encode)

private fun UriComponentsBuilder.configureScheme(includeScheme: Boolean, replaceHttpWithHttps: Boolean) = apply {
    if (!includeScheme) {
        scheme(null)
    } else {
        if (replaceHttpWithHttps) {
            scheme("https")
        }
    }
}

private fun UriComponentsBuilder.configureParameters(keep: Boolean) = apply {
    if (!keep) {
        replaceQueryParams(null)
    }
}

private fun UriComponentsBuilder.toUriString(encode: Boolean) =
    build(encode).toUriString()