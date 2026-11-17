package com.miningbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MiningbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiningbotApplication.class, args);
	}

}
