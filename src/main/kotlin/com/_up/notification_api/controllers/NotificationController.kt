package com._up.notification_api.controllers

import com._up.notification_api.utils.Message
import com._up.notification_api.services.NotificationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/notifications")
@RestController
class NotificationController(private val notificationService: NotificationService) {

    @PostMapping
    fun sendNotification(@RequestBody message: Message) =
        notificationService.sendNotification(message)
}