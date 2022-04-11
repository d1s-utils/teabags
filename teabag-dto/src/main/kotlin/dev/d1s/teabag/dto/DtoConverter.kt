package dev.d1s.teabag.dto

import dev.d1s.teabag.stdlib.exception.operationNotSupported

public interface DtoConverter<D : Any, E : Any> {

    public fun convertToDto(entity: E): D {
        operationNotSupported()
    }

    public fun convertToEntity(dto: D): E {
        operationNotSupported()
    }
}