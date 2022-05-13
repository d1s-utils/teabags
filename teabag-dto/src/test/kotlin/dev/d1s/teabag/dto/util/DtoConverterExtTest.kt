package dev.d1s.teabag.dto.util

import dev.d1s.teabag.dto.DtoSetConverterFacade
import dev.d1s.teabag.dto.testUtil.mockDtoConverter
import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isNull

internal class DtoConverterExtTest {

    private val converter = mockDtoConverter()

    @Test
    fun `should return valid DtoSetConverterFacade`() {
        expectThat(
            converter.converterForSet()
        ).isA<DtoSetConverterFacade<String, String>>()
    }

    @Test
    fun `should conditionally convert to dto and return valid one`() {
        expectThat(
            converter.convertToDtoIf(VALID_STUB, true)
        ) isEqualTo VALID_STUB
    }

    @Test
    fun `should conditionally convert to dto and return null`() {
        expectThat(
            converter.convertToDtoIf(VALID_STUB, false)
        ).isNull()
    }
}