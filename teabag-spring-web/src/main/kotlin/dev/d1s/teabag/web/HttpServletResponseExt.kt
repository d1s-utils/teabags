/*
 * Copyright 2022 Teabags project contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.d1s.teabag.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import dev.d1s.teabag.web.dto.ErrorDto
import org.springframework.http.MediaType
import javax.servlet.http.HttpServletResponse

private val objectMapper = ObjectMapper().registerModule(JavaTimeModule())

public fun HttpServletResponse.sendErrorDto(errorDtoConfiguration: ErrorDto.() -> Unit) {
    val errorDto = ErrorDto().apply(errorDtoConfiguration)
    contentType = MediaType.APPLICATION_JSON_VALUE
    status = errorDto.status
    outputStream.print(
        objectMapper.writeValueAsString(errorDto)
    )
}