package com.prateekv.testing.springseleniumautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class SpringSeleniumAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSeleniumAutomationApplication.class, args);
	}

}
