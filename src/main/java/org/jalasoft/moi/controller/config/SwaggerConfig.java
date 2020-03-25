/**
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package org.jalasoft.moi.controller.config;

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

import java.util.ArrayList;
import java.util.List;

/**
 * Implements basic configurations and documentations on Swagger user interface.
 *
 * @author Carlos Meneses
 * @version 1.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Documents information the app RESTful web service
     *
     * @return The documentation that swagger shows on the browser
     */
    @Bean
    public Docket apiDocket() {

        Contact contact = new Contact(
                "Jalasoft",
                "http://www.jalasoft.com/",
                "paolo.sandoval@jalasoft.com"
        );

        List<VendorExtension> vendorExtensions = new ArrayList<>();

        ApiInfo apiInfo = new ApiInfo(
                "Multilaguage Online Ide (MOI) app RESTful Web Service",
                "This pages documents Multilaguage Online Ide app RESTful Web Service endpoints",
                "1.0",
                "http://www.jalasoft.com/terms", contact,
                "Apache 2.0", "http://www.jalasoft.com/privacy",vendorExtensions);

        Docket docket =  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.jalasoft.moi.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}
