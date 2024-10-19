package com._up.notification_api.services

import com._up.notification_api.data.persistence.INotificationRepository
import com._up.notification_api.utils.Message
import com._up.notification_api.data.model.Notification
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class NotificationService(
    private val messagingTemplate: SimpMessagingTemplate,
    private val notificationRepository: INotificationRepository
) {
    fun getNotifications(pageNumber: Int, pageSize: Int): Page<Notification> =
        notificationRepository.findAll( PageRequest.of(pageNumber, pageSize) )

    fun sendNotification(message: Message) =
        message.buildNotification().also {
            messagingTemplate.convertAndSend("/admins", it)
            notificationRepository.save(it)
        }
}