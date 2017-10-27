package com.hiper2d.config

import com.hiper2d.handler.EchoHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.router

@Configuration
class WebFluxConfig: WebFluxConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**").allowedOrigins("*")
    }

    @Bean
    fun echoRouter(echoHandler: EchoHandler) = router {
        GET("/echo").nest {
            accept(TEXT_HTML, echoHandler::echo)
        }
    }
}