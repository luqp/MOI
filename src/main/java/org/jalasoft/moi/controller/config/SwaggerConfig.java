/*
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
import org.springframework.http.HttpHeaders;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

/**
 * Implements basic configurations and documentations on Swagger user interface.
 *
 * @author Carlos Meneses
 *         Lucero Quiroga Perez
 * @version 1.3
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
                "Apache 2.0", "http://www.jalasoft.com/privacy", vendorExtensions);

        List<SecurityScheme> schemes = new ArrayList<>();
        schemes.add(new ApiKey("JWT", HttpHeaders.AUTHORIZATION, "header"));

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .securitySchemes(schemes)
                .securityContexts(singletonList(securityContext()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.jalasoft.moi.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

    /**
     * Set ups the scope to use the security reference JWT to handler the authorizations.
     *
     * @return a list of SecurityReference
     */
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(
                new SecurityReference("JWT", authorizationScopes));
    }

    /**
     * Builds the authorizations to apply to each api operation.
     * To customize which request mappings the list of authorizations are applied.
     *
     * @return SecurityContext default set of authorizations
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    /**
     * Builds the security configuration to handler the header in swagger.
     *
     * @return SecurityConfiguration
     */
    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder
                .builder()
                .scopeSeparator(",")
                .additionalQueryStringParams(null)
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .build();
    }
}
