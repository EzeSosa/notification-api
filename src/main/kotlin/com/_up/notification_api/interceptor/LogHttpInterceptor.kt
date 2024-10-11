package com._up.notification_api.interceptor

import com._up.notification_api.data.model.Log
import com._up.notification_api.data.persistence.LogDAO
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import ua_parser.Parser

@Component
class LogHttpInterceptor(private val logDAO: LogDAO) : HandlerInterceptor {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(LogHttpInterceptor::class.java)
    }

    override fun postHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        modelAndView: ModelAndView?
    ) {

        val client = Parser()
            .parse(
                request.getHeader("user-agent")
            )

        logDAO.save(
            Log(
                endpoint = request.requestURI,
                browser = client.userAgent.family
            )
        )

        logger.info("Saved new log from log http interceptor")
    }
}