package dev.d1s.teabag.mapstruct

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class MappersTest {

    @Test
    fun `should return valid mapper`() {
        mockkStatic(Mappers::class) {
            val any = Any()

            every {
                Mappers.getMapper(Any::class.java)
            } returns any

            expectThat(getMapper<Any>()) isEqualTo any

            verify {
                Mappers.getMapper(Any::class.java)
            }
        }
    }
}