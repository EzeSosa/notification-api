package com._up.notification_api.data

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface INotificationRepository : MongoRepository<Notification, UUID>