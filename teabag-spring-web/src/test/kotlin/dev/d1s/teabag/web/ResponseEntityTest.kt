package dev.d1s.teabag.web

import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class ResponseEntityTest {

    @Test
    fun `should return valid no content response entity`() {
        expectThat(noContent) isEqualTo ResponseEntity.noContent().build()
    }
}