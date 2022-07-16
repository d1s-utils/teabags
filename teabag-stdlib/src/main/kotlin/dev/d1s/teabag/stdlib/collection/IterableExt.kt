/*
 * Copyright 2022 Teabags project contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

public inline fun <E, R> Iterable<E>.mapToMutableList(transform: (E) -> R): MutableList<R> =
    this.map(transform).toMutableList()

public fun Iterable<*>.hasDuplicates(): Boolean = this.toSet().size != this.toList().size

public fun <E, T> Iterable<E>.hasDuplicatesOf(selector: (E) -> T): Boolean = this.map {
    selector(it)
}.hasDuplicates()