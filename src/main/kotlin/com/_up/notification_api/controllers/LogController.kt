package com._up.notification_api.controllers

import com._up.notification_api.services.LogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/logs")
@RestController
class LogController(private val logService: LogService) {

    @GetMapping
    fun getAll() = logService.getAll()

}