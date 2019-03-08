package com.chaselx.apidoc.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.ant;

/**
 * @author ChaselX
 * @date 2019/1/30 11:22
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error"))))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Document")
                .description("API Document for Spring Boot 2 Project")
                .contact(new Contact("ChaselX", "", ""))
                .version("1.0")
                .build();
    }
}
