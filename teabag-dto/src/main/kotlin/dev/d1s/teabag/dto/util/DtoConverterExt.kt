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

package dev.d1s.teabag.dto.util

import dev.d1s.teabag.dto.DtoConverter
import dev.d1s.teabag.dto.DtoListConverterFacade

public fun <D : Any, E : Any> DtoConverter<D, E>.converterForList(): DtoListConverterFacade<D, E> =
    DtoListConverterFacade(this)

public fun <D : Any, E : Any> DtoConverter<D, E>.convertToDtoIf(entity: E, condition: Boolean): D? =
    if (condition) {
        this.convertToDto(entity)
    } else {
        null
    }