package com.heycar.pairingsession

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PairingServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(PairingServiceApplication::class.java, *args)
}
