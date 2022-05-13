package dev.d1s.teabag.dto.util

import dev.d1s.teabag.dto.testUtil.mockDtoConverter
import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isNull

internal class DtoSetConverterFacadeExtTest {

    private val dtoSetConverterFacade =
        mockDtoConverter().converterForSet()

    @Test
    fun `should conditionally convert to dto and return valid one`() {
        expectThat(
            dtoSetConverterFacade.convertToDtoSetIf(
                setOf(VALID_STUB),
                true
            )
        ) isEqualTo setOf(VALID_STUB)
    }

    @Test
    fun `should conditionally convert to dto and return null`() {
        expectThat(
            dtoSetConverterFacade.convertToDtoSetIf(
                setOf(VALID_STUB),
                false
            )
        ).isNull()
    }
}