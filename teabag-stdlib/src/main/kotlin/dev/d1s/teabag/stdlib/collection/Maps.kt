package dev.d1s.teabag.stdlib.collection

public fun <K : Any, V> mapOfNotNullValues(vararg pairs: Pair<K, V>): Map<K, V & Any> = pairs.filter {
    it.second != null
}.associate {
    it.first to it.second!!
}