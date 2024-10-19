package com._up.notification_api.services

import com._up.notification_api.data.model.Notification
import com._up.notification_api.data.persistence.INotificationRepository
import com._up.notification_api.utils.Message
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.messaging.simp.SimpMessagingTemplate

@ExtendWith(MockitoExtension::class)
class NotificationServiceTest {

    @InjectMocks
    private lateinit var notificationService: NotificationService

    @Mock
    private lateinit var notificationRepository: INotificationRepository

    @Mock
    private lateinit var messagingTemplate: SimpMessagingTemplate

    @Mock
    private lateinit var message: Message

    @Test
    fun `should return paginated notifications`() {
        val notifications = listOf(Notification("Test notification"))
        val page: Page<Notification> = PageImpl(notifications)
        val pageRequest: PageRequest = PageRequest.of(1, 10)

        `when`(notificationRepository.findAll(pageRequest)).thenReturn(page)

        val result = notificationService.getNotifications(1, 10)

        assertEquals(1, result.totalElements)
        verify(notificationRepository, times(1)).findAll(pageRequest)
    }

    @Test
    fun `should send and save notification`() {
        val notification = Notification("Test Message")

        `when`(message.buildNotification()).thenReturn(notification)

        notificationService.sendNotification(message)

        verify(messagingTemplate, times(1)).convertAndSend("/admins", notification)

        verify(notificationRepository, times(1)).save(notification)
    }
}