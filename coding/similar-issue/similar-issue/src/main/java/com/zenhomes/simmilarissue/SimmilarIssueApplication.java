package com.zenhomes.simmilarissue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class SimmilarIssueApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SimmilarIssueApplication.class, args);
	}
}
