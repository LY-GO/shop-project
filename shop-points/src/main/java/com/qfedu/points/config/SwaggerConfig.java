package com.qfedu.points.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {
    /**
     * Docket-配置信息
     * Api-接口文档相关介绍
     */

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("xxx项目接口文档").description("xxx项目的所有api文档").build();

    }

    /**
     * 注解注入-方法名或类名
     *
     * @return
     */
    @Bean
    public Docket docket(ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo);
    }
}
