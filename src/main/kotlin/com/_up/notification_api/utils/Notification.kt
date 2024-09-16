package com._up.notification_api.utils

import java.time.LocalDateTime

data class Notification(
    val content: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)