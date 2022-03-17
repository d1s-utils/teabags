package dev.d1s.teabag.stdlib.text

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
