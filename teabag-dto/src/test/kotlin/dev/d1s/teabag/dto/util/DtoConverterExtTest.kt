package dev.d1s.teabag.dto.util

import dev.d1s.teabag.dto.DtoSetConverterFacade
import dev.d1s.teabag.dto.testUtil.mockDtoConverter
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA

internal class DtoConverterExtTest {

    @Test
    fun `should return valid DtoSetConverterFacade`() {
        expectThat(
            mockDtoConverter().converterForSet()
        ).isA<DtoSetConverterFacade<String, String>>()
    }
}