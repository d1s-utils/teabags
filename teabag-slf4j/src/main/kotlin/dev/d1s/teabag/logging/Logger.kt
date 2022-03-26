package dev.d1s.teabag.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

public fun logger(kClass: KClass<*>): Logger = LoggerFactory.getLogger(kClass.java)