package dev.d1s.teabag.dto

import dev.d1s.teabag.stdlib.collection.mapToSet

public class DtoSetConverterFacade<D : Any, E : Any>(
    private val dtoConverter: DtoConverter<D, E>
) {
    public fun convertToDtoSet(entities: Set<E>): Set<D> =
        entities.mapToSet {
            dtoConverter.convertToDto(it)
        }

    public fun convertToEntitySet(dtos: Set<D>): Set<E> =
        dtos.mapToSet {
            dtoConverter.convertToEntity(it)
        }
}