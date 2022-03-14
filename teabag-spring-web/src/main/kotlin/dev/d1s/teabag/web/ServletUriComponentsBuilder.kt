package dev.d1s.teabag.web

import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import org.springframework.web.util.UriComponentsBuilder

public fun appendPath(value: String, useHttps: Boolean = true): String =
    ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{value}")
        .apply {
            if (useHttps) {
                httpsScheme()
            }
        }
        .buildAndExpand(value)
        .toUriString()

public fun currentUriWithNoPath(useHttps: Boolean = true): String =
    ServletUriComponentsBuilder
        .fromCurrentRequest()
        .replacePath(null)
        .apply {
            if (useHttps) {
                httpsScheme()
            }
        }
        .toUriString()

public fun UriComponentsBuilder.httpsScheme(): UriComponentsBuilder = apply {
    scheme("https")
}