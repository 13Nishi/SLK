package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@ComponentScan({"com.example.*"})


@SpringBootApplication
public class DemoAbcBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAbcBankApplication.class, args);
	}

}
