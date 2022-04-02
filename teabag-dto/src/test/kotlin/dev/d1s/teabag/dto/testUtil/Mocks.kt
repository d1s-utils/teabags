package dev.d1s.teabag.dto.testUtil

import dev.d1s.teabag.dto.DtoConverter
import dev.d1s.teabag.testing.constant.INVALID_STUB
import dev.d1s.teabag.testing.constant.VALID_STUB

internal fun mockDtoConverter(): DtoConverter<String, String> = object : DtoConverter<String, String> {
    override fun convertToDto(entity: String): String = VALID_STUB
    override fun convertToEntity(dto: String): String = INVALID_STUB
}