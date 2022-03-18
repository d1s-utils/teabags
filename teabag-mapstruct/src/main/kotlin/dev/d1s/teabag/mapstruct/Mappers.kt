package dev.d1s.teabag.mapstruct

import org.mapstruct.factory.Mappers

public inline fun <reified T> getMapper(): T = Mappers.getMapper(T::class.java)