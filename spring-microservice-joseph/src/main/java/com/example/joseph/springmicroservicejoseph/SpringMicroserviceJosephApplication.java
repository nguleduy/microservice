package com.example.joseph.springmicroservicejoseph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class SpringMicroserviceJosephApplication {

  @Bean
  @LoadBalanced //he will do the intelligence needed to use application names in eureka
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringMicroserviceJosephApplication.class, args);
  }

}
