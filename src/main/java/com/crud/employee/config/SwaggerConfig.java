package com.crud.employee.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crud.employee"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }
	
	private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Employee Management Portal - API Documentation")
                .description("\"Swagger configuration for Employee Management Portal \"")
                .version("1.1.0")
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Rambos Web Portal", "http://localhost:3000", "rambosadmission@ritedu.com"))
                .build();
    }

}
