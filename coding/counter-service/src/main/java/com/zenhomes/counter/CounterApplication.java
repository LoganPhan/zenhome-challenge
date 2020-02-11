package com.zenhomes.counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@EnableFeignClients
public class CounterApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CounterApplication.class, args);
	}
	
}
