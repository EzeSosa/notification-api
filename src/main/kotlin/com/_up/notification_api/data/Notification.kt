package com._up.notification_api.data

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class Notification(
    val content: String,
    val timestamp: LocalDateTime = LocalDateTime.now(),

    @Id
    val id: UUID = UUID.randomUUID()
) {
    constructor() : this("")
}