package uno.d1s.teabag.testing.constant

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class StubConstantsTest {

    @Test
    fun `should return 'v'`() {
        expectThat(VALID_STUB).isEqualTo("v")
    }

    @Test
    fun `should return 'i'`() {
        expectThat(INVALID_STUB).isEqualTo("i")
    }
}