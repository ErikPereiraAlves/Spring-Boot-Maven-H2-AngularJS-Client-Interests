package com.erikalves.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@SpringBootApplication(scanBasePackages={"com.erikalves.application"})

/*
@EnableResourceServer will turn our application into a resource server
(enables Spring Security filter to authenticate requests via an incoming OAuth2 token).
This secures everything in the server except for the oauth endpoints, e.g. /oauth/authorize
 */
class UserRiskApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRiskApplication.class, args);
    }
}