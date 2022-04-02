package dev.d1s.teabag.dto.util

import dev.d1s.teabag.dto.DtoConverter
import dev.d1s.teabag.dto.DtoSetConverterFacade

public fun <D : Any, E : Any> DtoConverter<D, E>.converterForSet(): DtoSetConverterFacade<D, E> =
    DtoSetConverterFacade(this)