package dev.d1s.teabag.testing

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

public inline fun <R> assertDoesNotThrowBlocking(crossinline block: suspend () -> R): R = runBlocking {
    assertDoesNotThrow {
        block()
    }
}

public inline fun <reified E : Exception> assertThrowsBlocking(crossinline block: suspend () -> Unit): E = runBlocking {
    assertThrows {
        block()
    }
}