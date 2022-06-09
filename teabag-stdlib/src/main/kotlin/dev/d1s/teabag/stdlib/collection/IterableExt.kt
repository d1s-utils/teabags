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

public fun Iterable<String>.toSpaceDelimitedString(): String = this.joinToString(" ")

public fun Iterable<String>.lengthiestLine(): String = this.maxByOrNull {
    it.length
} ?: throw IllegalArgumentException("This iterable is empty.")

public inline fun <E, R> Iterable<E>.mapToSet(transform: (E) -> R): Set<R> =
    this.map(transform).toSet()

public inline fun <E, R> Iterable<E>.mapToMutableSet(transform: (E) -> R): MutableSet<R> =
    this.map(transform).toMutableSet()

public fun Iterable<*>.hasDuplicates(): Boolean = this.toSet().size != this.toList().size

public fun <E, T> Iterable<E>.hasDuplicatesOf(selector: (E) -> T): Boolean = this.map {
    selector(it)
}.hasDuplicates()