package com._up.notification_api.controllers

import com._up.notification_api.services.LogService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/logs")
@RestController
class LogController(private val logService: LogService) {

    @GetMapping
    fun getAll() = logService.getAll()

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: UUID) = logService.getOne(id)

}