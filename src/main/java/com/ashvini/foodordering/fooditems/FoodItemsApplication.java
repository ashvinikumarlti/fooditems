package com.ashvini.foodordering.fooditems;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
public class FoodItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodItemsApplication.class, args);
	}
	
	@Bean
    public Docket productApi() {
      return new Docket(DocumentationType.SWAGGER_2).select()
    	  .paths(PathSelectors.ant("/fooditem/**"))
          .apis(RequestHandlerSelectors.basePackage("com.ashvini.foodordering"))
          .build()
          .apiInfo(apiInfo());
    }
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Food Items API",
				"API for accessing the Food Items and perform Searches",
				"1.0",
				"HCL Technologies",
				new springfox.documentation.service.Contact("Ashvini", "https://www.linkedin.com/in/ashvini-kumar-16815a17/", "ashvinikb2004@yahoo.com"),
				"API License",
				"http://www.hcl.com",
				Collections.emptyList());
	}

}
