package dev.d1s.teabag.web

import org.springframework.web.servlet.support.ServletUriComponentsBuilder

public fun appendPath(value: String): String =
    ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{value}")
        .buildAndExpand(value)
        .toUriString()

public fun currentUriWithNoPath(): String =
    ServletUriComponentsBuilder
        .fromCurrentRequest()
        .replacePath(null)
        .toUriString()