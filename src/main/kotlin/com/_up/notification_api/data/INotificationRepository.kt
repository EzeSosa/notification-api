package com._up.notification_api.data

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface INotificationRepository : JpaRepository<Notification, UUID>