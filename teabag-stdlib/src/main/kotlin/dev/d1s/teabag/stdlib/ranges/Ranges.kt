package dev.d1s.teabag.stdlib.ranges

public fun String.parseIntRange(): IntRange =
    this.split("..", limit = 2).let {
        if (it.size < 2) {
            throw IllegalArgumentException("Invalid range provided.")
        }

        it.first().toInt()..it.last().toInt()
    }