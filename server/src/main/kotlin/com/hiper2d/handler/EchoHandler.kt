package com.hiper2d.handler

import com.hiper2d.service.EchoService
import com.hiper2d.service.FibonacciService
import org.springframework.http.MediaType.TEXT_HTML
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import java.time.Duration.ofMillis

@Component
class EchoHandler(fibonacciService: FibonacciService, val echoService: EchoService) {
    final val fibonacciStream = fibonacciService.fetchFibonacciStream(ofMillis(1000)).share()

    fun echo(req: ServerRequest) = ok()
            .contentType(TEXT_HTML)
            .body(echoService.echo(), String::class.java)

    fun countFibonacci(req: ServerRequest) = ok()
            .contentType(TEXT_HTML)
            .body(fibonacciStream, String::class.java)
}