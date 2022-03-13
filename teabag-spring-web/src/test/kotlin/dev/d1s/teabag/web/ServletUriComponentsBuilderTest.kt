package dev.d1s.teabag.web

import dev.d1s.teabag.testing.constant.VALID_STUB
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Test
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class ServletUriComponentsBuilderTest {

    @Test
    fun `should return valid path`() {
        mockkStatic(ServletUriComponentsBuilder::class) {
            every {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{value}")
                    .buildAndExpand(VALID_STUB)
                    .toUri()
                    .toString()
            } returns VALID_STUB

            expectThat(
                appendPath(VALID_STUB)
            ).isEqualTo(VALID_STUB)
        }
    }
}