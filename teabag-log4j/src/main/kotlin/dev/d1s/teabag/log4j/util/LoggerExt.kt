package dev.d1s.teabag.log4j.util

import org.apache.logging.log4j.Logger

public inline fun Logger.lazyDebug(lazyMessage: () -> String) {
    if (this.isDebugEnabled) {
        this.debug(
            lazyMessage()
        )
    }
}