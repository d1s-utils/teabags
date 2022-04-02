package dev.d1s.teabag.data

import org.springframework.beans.support.PagedListHolder
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest

private val Int?.thisOrDefaultPageSize get() = this ?: 20
private val Int?.thisOrDefaultPage get() = this ?: 0

public fun <T> Iterable<T>.toPage(page: Int?, size: Int?): Page<T> {
    val notNullPage = page.thisOrDefaultPage
    val notNullPageSize = size.thisOrDefaultPageSize

    return PageImpl(PagedListHolder(this.toList()).apply {
        this.page = notNullPage
        this.pageSize = notNullPageSize
    }.pageList, PageRequest.of(notNullPage, notNullPageSize), this.count().toLong())
}