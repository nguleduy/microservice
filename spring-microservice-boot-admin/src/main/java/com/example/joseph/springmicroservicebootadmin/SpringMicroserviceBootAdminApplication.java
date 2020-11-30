package com.example.joseph.springmicroservicebootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringMicroserviceBootAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringMicroserviceBootAdminApplication.class, args);
  }

}
