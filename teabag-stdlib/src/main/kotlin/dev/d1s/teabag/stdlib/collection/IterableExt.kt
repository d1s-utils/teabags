package dev.d1s.teabag.stdlib.collection

public infix fun <T> Iterable<T>.anyIn(other: Iterable<T>): Boolean {
    forEach {
        if (it in other) {
            return true
        }
    }

    return false
}