package com.example.joseph.springmicroserviceconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

//@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration
public class SpringMicroserviceConfigServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringMicroserviceConfigServerApplication.class, args);
  }

}
