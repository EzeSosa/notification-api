package com._up.notification_api.data.model

import java.time.LocalDateTime
import java.util.UUID

data class Log(
    val id: UUID = UUID.randomUUID(),
    val issuedAt: LocalDateTime = LocalDateTime.now(),
    val endpoint: String,
    val browser: String
)