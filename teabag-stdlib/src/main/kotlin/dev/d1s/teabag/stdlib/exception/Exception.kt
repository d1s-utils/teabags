package dev.d1s.teabag.stdlib.exception

@Suppress("NOTHING_TO_INLINE") // inline is used to provide the correct stack trace.
public inline fun operationNotSupported(): Nothing =
    throw IllegalStateException("This operation is not supported.")