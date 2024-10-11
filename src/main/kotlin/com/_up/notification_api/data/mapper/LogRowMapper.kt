package com._up.notification_api.data.mapper

import com._up.notification_api.data.model.Log
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.UUID

@Component
class LogRowMapper : RowMapper<Log> {

    override fun mapRow(rs: ResultSet, rowNum: Int): Log =
        Log(
            UUID.fromString(rs.getString("id")),
            rs.getTimestamp("issued_at").toLocalDateTime(),
            rs.getString("endpoint"),
            rs.getString("browser"),
        )

}