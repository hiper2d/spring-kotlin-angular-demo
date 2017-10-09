package com.hiper2d.service

import org.springframework.stereotype.Service
import reactor.core.publisher.toFlux
import java.time.Duration
import kotlin.coroutines.experimental.buildIterator

@Service
class FibonacciService {

    fun fetchFibonacciStream(interval: Duration) = fibonacci.toFlux()
            .delayElements(interval)
            .map{it.toString()}
            .log("ss-fibonacci")

    val fibonacci = buildIterator {
        var a = 0L
        var b = 1L
        while (true) {
            yield(b)
            val next = a + b
            a = b
            b = next
        }
    }
}