
package com.app.ecommerce.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.app.ecommerce.api", "com.app.application", "com.app.domain", "com.app.infrastructure"})
@EnableJpaRepositories(basePackages = "com.app.domain.repositories")
@ComponentScan(basePackages = {"com.app.domain.repositories"})
@EntityScan(basePackages = "com.app.domain.entity")
public class EcommerceApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApiApplication.class, args);
    }
}
