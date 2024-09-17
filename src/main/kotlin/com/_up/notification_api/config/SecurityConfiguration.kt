package com._up.notification_api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfiguration {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .csrf { csrf -> csrf.disable() }
            .cors { cors -> cors.configurationSource(corsConfigurationSource()) }
            .authorizeHttpRequests { httpRequests -> httpRequests.anyRequest().hasRole("ADMIN") }
            .httpBasic(Customizer.withDefaults())
            .build()

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration().apply {
            allowedOrigins = listOf("http://localhost:5173")
            allowedMethods = listOf("*")
            allowCredentials = true
        }

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfiguration)
        return source
    }

    @Bean
    fun userDetailsService(): UserDetailsService =
        InMemoryUserDetailsManager(
            User.builder()
                .username("esosa")
                .password("{noop}12345")
                .roles("ADMIN")
                .build(),

            User.builder()
                .username("lmessi")
                .password("{noop}12345")
                .roles("USER")
                .build()
        )
}