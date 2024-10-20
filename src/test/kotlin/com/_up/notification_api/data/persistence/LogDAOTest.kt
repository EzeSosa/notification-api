package com._up.notification_api.data.persistence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import java.util.UUID

@SpringBootTest
@Sql("/schema.sql")
@ActiveProfiles("test")
class LogDAOTest {

    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    @Autowired
    private lateinit var logDAO: LogDAO

    companion object {
        const val SQL = "INSERT INTO log (id, endpoint, browser) VALUES (?, ?, ?)"
    }

    @Test
    fun `should return all logs`() {

        jdbcTemplate.update(
            SQL,
            UUID.randomUUID().toString(), "/v1/demo", "Firefox",
        )

        jdbcTemplate.update(
            SQL,
            UUID.randomUUID().toString(), "/v1/hello", "Chrome",
        )

        val logs = logDAO.getAll()

        assertEquals(2, logs.size)

        assertEquals("/v1/demo", logs[0].endpoint)
        assertEquals("/v1/hello", logs[1].endpoint)

        assertEquals("Firefox", logs[0].browser)
        assertEquals("Chrome", logs[1].browser)
    }

    @Test
    fun `should return one by id`() {
        val logId = UUID.randomUUID()

        jdbcTemplate.update(
            SQL,
            logId.toString(), "/v1/hey", "Edge"
        )

        val log = logDAO.getOne(logId)

        assertNotNull(log)

        assertEquals("Edge", log.browser)
        assertEquals("/v1/hey", log.endpoint)
    }

}