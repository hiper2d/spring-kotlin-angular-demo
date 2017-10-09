package com.hiper2d.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class EchoService {
    fun echo() = Mono.just("Hey")
}