package com.ideacome.consumer.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"com.ideacome.consumer.consumeService"})
@SpringBootApplication(scanBasePackages={"com.ideacome.consumer"})
public class BootConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootConsumerApplication.class, args);
		
	}
}
