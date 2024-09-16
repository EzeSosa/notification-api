package com._up.notification_api.controllers

import com._up.notification_api.utils.Message
import com._up.notification_api.services.NotificationService
import org.springframework.web.bind.annotation.*

@RequestMapping("/notifications")
@RestController
class NotificationController(private val notificationService: NotificationService) {

    @GetMapping
    fun getNotifications(
        @RequestParam(defaultValue = "0") pageNumber: Int,
        @RequestParam(defaultValue = "5") pageSize: Int,
    ) =
        notificationService.getNotifications(pageNumber, pageSize)

    @PostMapping
    fun sendNotification(@RequestBody message: Message) =
        notificationService.sendNotification(message)
}