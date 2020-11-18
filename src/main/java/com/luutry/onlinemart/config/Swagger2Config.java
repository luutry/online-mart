package com.luutry.onlinemart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Swagger2Config
 * @Description: Swagger2API文档的配置
 * @Author: Luutry
 * @Date: 2020/11/6 15:46
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.luutry.onlinemart.controller"))
                .paths(PathSelectors.any())
                .build();
                //添加登录认证

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API")
                .description("Online-mart")
                .contact("luutry")
                .version("1.0")
                .build();
    }



}
