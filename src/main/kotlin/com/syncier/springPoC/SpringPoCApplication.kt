package com.syncier.springPoC

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@SpringBootApplication
class SpringPoCApplication {
	@Bean
	@ConfigurationProperties("app.other")
	fun otherProps() = MyProps()

	@Bean
	@ConfigurationProperties("app.props")
	fun myProps() = MyProps()

	@Bean
	fun cmd(myProps: MyProps, otherProps: MyProps) = CommandLineRunner {
		println("myProps name = ${myProps.name}")
		println("otherProps name = ${otherProps.name}")
	}
}

fun main(args: Array<String>) {
	runApplication<SpringPoCApplication>(*args)
}

class MyProps {
	lateinit var name: String
}