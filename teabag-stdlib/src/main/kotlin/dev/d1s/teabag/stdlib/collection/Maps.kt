package dev.d1s.teabag.stdlib.collection

public fun <K : Any, V> mapOfNotNullValues(vararg pairs: Pair<K, V>): Map<K, V> = pairs.filter {
    it.second != null
}.toMap()