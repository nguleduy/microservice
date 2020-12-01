package com.example.joseph.springmicroservicetransportation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringMicroserviceTransportationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceTransportationApplication.class, args);
	}

}
