package dev.d1s.teabag.stdlib.collection

public infix fun <T> Iterable<T>.anyIn(other: Iterable<T>): Boolean {
    forEach {
        if (it in other) {
            return true
        }
    }

    return false
}

public inline fun <T, P : Any> Iterable<T>.multiply(principalObj: P, block: (T, P) -> P): P {
    var principal = principalObj

    forEach {
        principal = block(it, principal)
    }

    return principal
}