package dev.d1s.teabag.stdlib.collection

public inline fun <E, R> Set<E>.mapToSet(transform: (E) -> R): Set<R> =
    this.map(transform).toSet()