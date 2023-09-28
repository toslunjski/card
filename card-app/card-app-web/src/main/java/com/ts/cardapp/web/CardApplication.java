package com.ts.cardapp.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * @author Tomislav Slunjski
 * @since 18.1
 */
@SpringBootApplication (scanBasePackages = {"com.*"})
@ComponentScan (basePackages = {"com.*"})
@EnableJpaRepositories (basePackages = {"com.*"})
@EntityScan (basePackages = {"com.*"})
@EnableConfigurationProperties

public class CardApplication
{
    public static void main(String[] args) {

        SpringApplication.run(CardApplication.class, args);
    }
}