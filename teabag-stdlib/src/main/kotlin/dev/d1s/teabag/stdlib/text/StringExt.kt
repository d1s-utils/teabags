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

package dev.d1s.teabag.stdlib.text

import dev.d1s.teabag.stdlib.collection.lengthiestLine
import dev.d1s.teabag.stdlib.collection.multiply
import java.net.MalformedURLException
import java.net.URL

public class PaddingDsl {
    public var top: Int = 0
    public var bottom: Int = 0
    public var left: Int = 0
    public var right: Int = 0
}

public fun String.padding(padding: PaddingDsl.() -> Unit): String {
    val config = PaddingDsl().apply(padding)

    return "${"\n".repeat(config.top)}${
        split("\n").joinToString("\n") {
            "${" ".repeat(config.left)}$it${" ".repeat(config.right)}"
        }
    }${"\n".repeat(config.bottom)}"
}

public fun String.padding(value: Int): String = padding {
    top = value
    bottom = value
    left = value
    right = value
}

public fun String?.thisOrEmpty(): String = this ?: ""

public fun String.isUrl(): Boolean = try {
    URL(this)
    true
} catch (_: MalformedURLException) {
    false
}

public fun String.replacePlaceholder(vararg replacements: Pair<String, String>): String =
    replacements.asIterable().multiply(this) { it, principal ->
        principal.replace("{${it.first}}", it.second)
    }

public fun String.hasWhiteSpace(): Boolean = this.contains("\\s".toRegex())

public fun String.wrapLines(maxWidth: Int): String {
    val lines = this.lines().toMutableList()

    val lengthiestLine = lines.lengthiestLine()

    if (lengthiestLine.length <= maxWidth) {
        return this
    }

    val lengthiestLineWords = lengthiestLine.split("\\s+".toRegex())
    val lengthiestLineIndex = lines.indexOf(lengthiestLine)
    val lengthiestLineWordsHalf = (lengthiestLineWords.size / 2) - 1

    lines.removeAt(lengthiestLineIndex)

    lines.addAll(
        lengthiestLineIndex,
        buildList {
            val firstPart = StringBuilder()
            val secondPart = StringBuilder()

            lengthiestLineWords.forEachIndexed { index, word ->
                if (index <= lengthiestLineWordsHalf) {
                    firstPart.append(word)

                    if (index != lengthiestLineWords.size - 1 && index != lengthiestLineWordsHalf) {
                        firstPart.append(" ")
                    }
                } else {
                    secondPart.append(word)

                    if (index != lengthiestLineWords.size - 1) {
                        secondPart.append(" ")
                    }
                }
            }

            add(firstPart.toString())
            add(secondPart.toString())
        }
    )

    val result = lines.joinToString("\n")

    val currentLengthiestLine = lines.lengthiestLine()

    return if (currentLengthiestLine.length > maxWidth && currentLengthiestLine.hasWhiteSpace()) {
        result.wrapLines(maxWidth)
    } else {
        result
    }
}
