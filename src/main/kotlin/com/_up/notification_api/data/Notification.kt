package com._up.notification_api.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime
import java.util.UUID

@Document
data class Notification(
    val content: String,
    val timestamp: LocalDateTime = LocalDateTime.now(),

    @Id
    val id: UUID = UUID.randomUUID()
) {
    constructor() : this("")
}