package dev.d1s.teabag.logging

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

public val logger: Logger
    inline get() = LogManager.getLogger()