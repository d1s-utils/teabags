package dev.d1s.teabag.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory

public val logger: Logger
    inline get() = LoggerFactory.getLogger(
        StackWalker.getInstance(
            StackWalker.Option.RETAIN_CLASS_REFERENCE
        ).callerClass
    )