package me.training.mobileapiservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class MobileApiServiceApplication

fun main(args: Array<String>) {
	runApplication<MobileApiServiceApplication>(*args)
}
