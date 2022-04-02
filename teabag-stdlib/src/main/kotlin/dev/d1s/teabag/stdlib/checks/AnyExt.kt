package dev.d1s.teabag.stdlib.checks

public fun <T> T?.checkNotNull(property: String): T =
    this ?: throw IllegalArgumentException("$property must not be null.")