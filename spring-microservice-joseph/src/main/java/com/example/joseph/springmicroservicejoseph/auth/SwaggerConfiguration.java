package com.example.joseph.springmicroservicejoseph.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public Docket forumApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.joseph.microservicejoseph.controller"))
            .paths(PathSelectors.any())
            .build()
            .ignoredParameterTypes(disableTemplateClassesModels())
            .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Spring Microservice - Joseph API")
            .description("Microservices Project Using: Spring Boot + Eureka (registry/discovery) + Spring Cloud (config server) "
                    + "+ Feign (Clientside LoadBalance) + Logs and distributed tracing with Papertrail "
                    + "+ Sleuth + Hystrix (Fallback and Circuit Breaker) + API Gateway + Spring Zuul "
                    + "+ Authentication and Authorization between microservices using OAuth2.")
            .contact(new Contact("Joseph", "https://github.com/nguleduy/", "nguleduy@gmail.com"))
            .license("License 1.0.0")
            .licenseUrl("https://github.com/nguleduy/microservice")
            .version("1.0.0")
            .build();
  }

  //Method that returns templates that will be hidden in the API documentation
  @SuppressWarnings("rawtypes")
  private Class[] disableTemplateClassesModels() {
    ArrayList<Class> classForDisable = new ArrayList<Class>();

    //Entities - Models - DTO and others...

    return classForDisable.toArray(new Class[classForDisable.size()]);
  }
}
