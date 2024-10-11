package com._up.notification_api.data.persistence

import com._up.notification_api.data.model.Log
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component

@Component
class LogDAO(
    private val jdbcTemplate: JdbcTemplate,
    private val logRowMapper: RowMapper<Log>
) {

    fun getAll(): List<Log> = jdbcTemplate.query(
        "SELECT * FROM log LIMIT 10",
        logRowMapper
    )

    fun save(log: Log): Int =
        jdbcTemplate.update(
            "INSERT INTO log(endpoint, browser) VALUES (?, ?)",
            log.endpoint,
            log.browser,
        )
}