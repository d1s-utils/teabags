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

package dev.d1s.teabag.web.dto

import dev.d1s.teabag.web.currentRequest
import org.springframework.http.HttpStatus
import java.time.Instant

public data class ErrorDto(
    var timestamp: Instant = Instant.now(),
    var status: Int = HttpStatus.INTERNAL_SERVER_ERROR.value(),
    var error: String = "Something went wrong.",
    var path: String = currentRequest.requestURI ?: "/"
)