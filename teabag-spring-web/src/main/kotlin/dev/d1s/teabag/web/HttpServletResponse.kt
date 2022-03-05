package dev.d1s.teabag.web

import com.fasterxml.jackson.databind.ObjectMapper
import dev.d1s.teabag.web.dto.ErrorDto
import org.springframework.http.MediaType
import javax.servlet.http.HttpServletResponse

private val objectMapper = ObjectMapper()

public fun HttpServletResponse.sendErrorDto(errorDtoConfiguration: ErrorDto.() -> Unit) {
    val errorDto = ErrorDto().apply(errorDtoConfiguration)
    contentType = MediaType.APPLICATION_JSON_VALUE
    status = errorDto.status
    writer.use {
        println(objectMapper.writeValueAsString(errorDto))
    }
}