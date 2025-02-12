package com.example.conductKafkaStreamDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.conductKafkaStreamDemo")
public class ConductKafkaStreamDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConductKafkaStreamDemoApplication.class, args);
	}

}
