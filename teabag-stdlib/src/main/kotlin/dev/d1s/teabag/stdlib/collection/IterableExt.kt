package dev.d1s.teabag.stdlib.collection

import kotlin.properties.Delegates

public infix fun <T> Iterable<T>.anyIn(other: Iterable<T>): Boolean {
    forEach {
        if (it in other) {
            return true
        }
    }

    return false
}

public inline fun <T, R : Any> Iterable<T>.multiply(block: (T) -> R): R {
    var result: R by Delegates.notNull()

    forEach {
        result = block(it)
    }

    return result
}