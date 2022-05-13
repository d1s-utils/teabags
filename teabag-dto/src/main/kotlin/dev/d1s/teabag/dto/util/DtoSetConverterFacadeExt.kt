package dev.d1s.teabag.dto.util

import dev.d1s.teabag.dto.DtoSetConverterFacade

public fun <D : Any, E : Any> DtoSetConverterFacade<D, E>.convertToDtoSetIf(
    entities: Set<E>,
    condition: Boolean
): Set<D>? =
    if (condition) {
        this.convertToDtoSet(entities)
    } else {
        null
    }