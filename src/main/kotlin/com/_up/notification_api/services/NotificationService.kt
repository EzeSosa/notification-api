package com._up.notification_api.services

import com._up.notification_api.utils.Message
import com._up.notification_api.utils.Notification
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class NotificationService(private val messagingTemplate: SimpMessagingTemplate) {

    fun sendNotification(message: Message) =
        messagingTemplate.convertAndSend("/admins", message.buildNotification())

    private fun Message.buildNotification() = Notification(message)
}