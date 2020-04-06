package com.espelho.challenger.uol

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.espelho.challenger.uol"])
class ChallengerUolApplication

fun main(args: Array<String>) {
	runApplication<ChallengerUolApplication>(*args)
}
