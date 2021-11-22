package com.spring.userability.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket userApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.spring.userability"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(metaInfo());
  }

  private ApiInfo metaInfo() {

    ApiInfo apiInfo = new ApiInfo(
        "User API REST",
        "API REST from user registration.",
        "1.0",
        "Terms of Service",
        new Contact("Edward Moreira", "https://aboute-me.netlify.app/",
            "edward.moreira@yahoo.com"),
        "Apache License Version 2.0",
        "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
    );

    return apiInfo;
  }
}
