package com._up.notification_api.utils

import com._up.notification_api.data.model.Notification

data class Message(
    val message: String
) {
    fun buildNotification() = Notification(message)
}