package com.alelo.backend.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.alelo.backend"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }
    public ApiInfo metaInfo(){
        return new ApiInfo(
                "Alelo Teste pratico",
                "Api Reste para cadastro de clientes",
                "1.0",
                "Gleisson Quixabeira",
                new Contact("Gleisson Quixabeira", "(98) 98150-9687","gleissontr@gmail.com"),
                "",
                "", new ArrayList<VendorExtension>()
        );
    }
}
