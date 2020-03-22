package com.nwafu.accountloginmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: rabbitManagement
 * @description: swagger文档配置类
 * @author: liu qinchang
 * @create: 2020-01-14 15:37
 **/

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //swagger要扫描的包路径
                .apis(RequestHandlerSelectors.basePackage("com.nwafu.accountloginmanagement.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("账号权限操作部分文档")
                .description("账号权限操作部分文档")
                .termsOfServiceUrl("localhost:8300/account")
                .contact(new Contact("Swagger测试","localhost:8300/swagger-ui.html","baidu@qq.com"))
                .version("1.0")
                .build();
    }
}
