package com._up.notification_api.data.persistence

import com._up.notification_api.data.model.Notification
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface INotificationRepository : MongoRepository<Notification, UUID>