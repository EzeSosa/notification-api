package com._up.notification_api.services

import com._up.notification_api.data.model.Log
import com._up.notification_api.data.persistence.LogDAO
import org.springframework.stereotype.Service

@Service
class LogService(private val logDAO: LogDAO) {

    fun getAll(): List<Log> = logDAO.getAll()

}