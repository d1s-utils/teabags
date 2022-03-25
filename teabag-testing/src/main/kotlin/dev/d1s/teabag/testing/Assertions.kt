package dev.d1s.teabag.testing

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.assertDoesNotThrow

public inline fun <R> assertDoesNotThrowBlocking(crossinline block: suspend () -> R): R = runBlocking {
    assertDoesNotThrow {
        block()
    }
}