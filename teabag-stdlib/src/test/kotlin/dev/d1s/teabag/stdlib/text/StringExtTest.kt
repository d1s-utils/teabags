package dev.d1s.teabag.stdlib.text

import dev.d1s.teabag.testing.constant.VALID_STUB
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isTrue

internal class StringExtTest {

    @Test
    fun `should return String with padding`() {
        expectThat(VALID_STUB.padding {
            top = 1
            bottom = 2
            left = 3
            right = 4
        }).isEqualTo("\n   $VALID_STUB    \n\n")
    }

    @Test
    fun `should return String with padding for all directions`() {
        expectThat("$VALID_STUB\n$VALID_STUB".padding(2)).isEqualTo(
            "\n\n  $VALID_STUB  \n  $VALID_STUB  \n\n"
        )
    }

    @Test
    fun `should return this String`() {
        expectThat(VALID_STUB.thisOrEmpty()).isEqualTo(VALID_STUB)
    }

    @Test
    fun `should return empty String`() {
        val nullableString: String? = null
        expectThat(nullableString.thisOrEmpty()).isEqualTo("")
    }

    @Test
    fun `should check if the string is a url`() {
        expectThat("https://d1s.dev/".isUrl()).isTrue()
    }

    @Test
    fun `should replace the placeholder`() {
        expectThat(
            "this is {stuff}".replacePlaceholder("stuff" to "replaced")
        ) isEqualTo "this is replaced"

        expectThat(
            "this is {stuff1} and {stuff2}".replacePlaceholder(
                "stuff1" to "replaced1",
                "stuff2" to "replaced2"
            )
        ) isEqualTo "this is replaced1 and replaced2"
    }
}