package dev.d1s.teabag.dto

public interface DtoConverter<D : Any, E : Any> {

    public fun convertToDto(entity: E): D

    public fun convertToEntity(dto: D): E
}