package dev.d1s.teabag.dto

public interface DtoValidator<D : Any> {

    public fun validate(dto: D)
}