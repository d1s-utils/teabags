package dev.d1s.teabag.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import dev.d1s.teabag.testing.constant.VALID_STUB
import dev.d1s.teabag.testing.mockRequest
import dev.d1s.teabag.testing.mockResponse
import dev.d1s.teabag.web.dto.ErrorDto
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.time.Instant

internal class HttpServletResponseExtTest {

    private val response = spyk(mockResponse)

    private val testErrorDto = ErrorDto(
        Instant.EPOCH,
        HttpStatus.BAD_REQUEST.value(),
        VALID_STUB,
        VALID_STUB
    )

    private val objectMapper = ObjectMapper().registerModule(JavaTimeModule())

    @Test
    fun `should send error`() {
        mockkStatic("dev.d1s.teabag.web.CurrentRequestKt") {
            every {
                currentRequest
            } returns mockRequest

            val content = objectMapper.writeValueAsString(testErrorDto)

            response.sendErrorDto {
                timestamp = testErrorDto.timestamp
                status = testErrorDto.status
                error = testErrorDto.error
                path = testErrorDto.path
            }

            expectThat(response.contentType).isEqualTo(MediaType.APPLICATION_JSON_VALUE)
            expectThat(response.status).isEqualTo(testErrorDto.status)
            expectThat(response.contentAsString).isEqualTo(content)

            verify {
                response.contentType = MediaType.APPLICATION_JSON_VALUE
            }

            verify {
                response.status = testErrorDto.status
            }
        }
    }
}