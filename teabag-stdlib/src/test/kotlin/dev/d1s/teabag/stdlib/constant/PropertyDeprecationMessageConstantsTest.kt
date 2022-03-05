package dev.d1s.teabag.stdlib.constant

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class PropertyDeprecationMessageConstantsTest {

    @Test
    fun `should return valid 'Property is deprecated'`() {
        expectThat(PROPERTY_DEPRECATION_MESSAGE).isEqualTo("Property is deprecated.")
    }

    @Test
    fun `should return PROPERTY_DEPRECATION_MESSAGE`() {
        expectThat(PROPERTY_DEPRECATED).isEqualTo(PROPERTY_DEPRECATION_MESSAGE)
    }
}