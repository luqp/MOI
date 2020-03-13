/**
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class implement basic configurations to get Swagger running in our project
 * and use it for specifications and tools that help us document our APIs.
 *
 * @version 1.1
 * @author Carlos Meneses
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Docket is the primary api configuration mechanism is initialized for swagger specification 2.0.
     * @return The documentation that swagger shows on the browser.
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.jalasoft.moi.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    /**
     * Information that are going to be show on the browser about the rest API.
     * @return ApiInfo of all setted documentation.
     */
    private ApiInfo apiInfo() {
        return new ApiInfo("Multilaguage Online Ide",
                "This api is a service of onLine Ide",
                "1.0",
                "urn:tos",
                ApiInfo.DEFAULT_CONTACT,
                "Apache 2.0",
                "http");
    }
}

