package dev.d1s.teabag.dto

import dev.d1s.teabag.dto.testUtil.mockDtoConverter
import dev.d1s.teabag.testing.constant.INVALID_STUB
import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactly
import strikt.assertions.isA

internal class DtoSetConverterFacadeTest {

    private val facade = DtoSetConverterFacade(
        mockDtoConverter()
    )

    @Test
    fun `should return valid set of dtos`() {
        expectThat(
            facade.convertToDtoSet(
                setOf(INVALID_STUB)
            )
        ) {
            isA<Set<String>>()
            containsExactly(VALID_STUB)
        }
    }

    @Test
    fun `should return valid set of entities`() {
        expectThat(
            facade.convertToEntitySet(
                setOf(VALID_STUB)
            )
        ) {
            isA<Set<String>>()
            containsExactly(INVALID_STUB)
        }
    }
}