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

package dev.d1s.teabag.data.jpa.util

import dev.d1s.teabag.data.jpa.Identifiable

public fun List<Identifiable<*>>.mapToIdList(): List<String?> =
    this.map {
        it.id?.asString
    }

public fun List<Identifiable<*>>.mapToNotNullIdList(): List<String> =
    this.map {
        requireNotNull(it.id?.asString)
    }