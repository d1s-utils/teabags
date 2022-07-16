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