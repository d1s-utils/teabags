package dev.d1s.teabag.web

import dev.d1s.teabag.testing.constant.VALID_STUB
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import org.springframework.web.util.UriComponentsBuilder
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class ServletUriComponentsBuilderTest {

    @Test
    fun `should return valid uri with appended path`() {
        mockServletUriComponentsBuilder {
            every {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{value}")
                    .httpsScheme()
                    .buildAndExpand(VALID_STUB)
                    .toUriString()
            } returns VALID_STUB

            expectThat(
                appendPath(VALID_STUB)
            ).isEqualTo(VALID_STUB)

            verify {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{value}")
                    .httpsScheme()
                    .buildAndExpand(VALID_STUB)
                    .toUriString()
            }
        }
    }

    @Test
    fun `should return valid uri with appended root path`() {
        mockServletUriComponentsBuilder {
            every {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .httpsScheme()
                    .replacePath(null)
                    .path(VALID_STUB)
                    .toUriString()
            } returns VALID_STUB

            expectThat(
                appendRootPath(VALID_STUB)
            ).isEqualTo(VALID_STUB)

            verify {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .httpsScheme()
                    .replacePath(null)
                    .path(VALID_STUB)
                    .toUriString()
            }
        }
    }

    @Test
    fun `should return valid uri with no path`() {
        mockServletUriComponentsBuilder {
            every {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .replacePath(null)
                    .httpsScheme()
                    .toUriString()
            } returns VALID_STUB

            expectThat(
                currentUriWithNoPath()
            ).isEqualTo(VALID_STUB)

            verify {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .replacePath(null)
                    .httpsScheme()
                    .toUriString()
            }
        }
    }

    private inline fun mockServletUriComponentsBuilder(crossinline block: () -> Unit) {
        mockkStatic(ServletUriComponentsBuilder::class) {
            block()
        }
    }

    private fun UriComponentsBuilder.httpsScheme() = apply {
        scheme("https")
    }
}