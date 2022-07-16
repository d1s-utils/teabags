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