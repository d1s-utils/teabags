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

package dev.d1s.teabag.dto

public class DtoListConverterFacade<D : Any, E : Any>(
    private val dtoConverter: DtoConverter<D, E>
) {
    public fun convertToDtoList(entities: List<E>): List<D> =
        entities.map {
            dtoConverter.convertToDto(it)
        }

    public fun convertToEntityList(dtos: List<D>): List<E> =
        dtos.map {
            dtoConverter.convertToEntity(it)
        }
}