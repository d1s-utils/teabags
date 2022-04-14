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
import java.net.URI

internal class ServletUriComponentsBuilderTest {

    private val testUri = URI("https://d1s.dev")

    @Test
    fun `should return valid uri with appended path`() {
        mockServletUriComponentsBuilder {
            every {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .configure()
                    .path("/$VALID_STUB")
                    .buildWithNoEncoding()
            } returns VALID_STUB

            expectThat(
                appendPath(VALID_STUB)
            ).isEqualTo(VALID_STUB)

            verify {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .configure()
                    .path("/$VALID_STUB")
                    .buildWithNoEncoding()
            }
        }
    }

    @Test
    fun `should return valid appended uri`() {
        mockServletUriComponentsBuilder {
            every {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .configure()
                    .path("/{value}")
                    .build(VALID_STUB)
            } returns testUri

            expectThat(
                appendUri(VALID_STUB)
            ) isEqualTo testUri

            verify {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .configure()
                    .path("/{value}")
                    .build(VALID_STUB)
            }
        }
    }

    @Test
    fun `should return valid uri with appended root path`() {
        mockServletUriComponentsBuilder {
            every {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .configure()
                    .replacePath(null)
                    .path("/$VALID_STUB")
                    .buildWithNoEncoding()
            } returns VALID_STUB

            expectThat(
                appendRootPath(VALID_STUB)
            ).isEqualTo(VALID_STUB)

            verify {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .configure()
                    .replacePath(null)
                    .path("/$VALID_STUB")
                    .buildWithNoEncoding()
            }
        }
    }

    @Test
    fun `should return valid uri with no path`() {
        mockServletUriComponentsBuilder {
            every {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .configure()
                    .replacePath(null)
                    .buildWithNoEncoding()
            } returns VALID_STUB

            expectThat(
                currentUriWithNoPath()
            ).isEqualTo(VALID_STUB)

            verify {
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .configure()
                    .replacePath(null)
                    .buildWithNoEncoding()
            }
        }
    }

    private inline fun mockServletUriComponentsBuilder(crossinline block: () -> Unit) {
        mockkStatic(ServletUriComponentsBuilder::class) {
            block()
        }
    }

    private fun UriComponentsBuilder.configure() = apply {
        scheme("https")
        replaceQueryParams(null)
    }

    private fun UriComponentsBuilder.buildWithNoEncoding() =
        build(false).toUriString()
}