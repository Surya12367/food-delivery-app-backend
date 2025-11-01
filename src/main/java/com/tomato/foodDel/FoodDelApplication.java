package com.tomato.foodDel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FoodDelApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDelApplication.class, args);
	}

}
