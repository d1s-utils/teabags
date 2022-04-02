package dev.d1s.teabag.web

import org.springframework.http.ResponseEntity

public fun <T> ok(body: T): ResponseEntity<Any> = ResponseEntity.ok(body)