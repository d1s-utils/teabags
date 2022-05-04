package dev.d1s.teabag.log4j

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

// "LogManager#getLogger returns a Logger with the name of the calling class."
@Suppress("NOTHING_TO_INLINE")
public inline fun logger(): Logger = LogManager.getLogger()