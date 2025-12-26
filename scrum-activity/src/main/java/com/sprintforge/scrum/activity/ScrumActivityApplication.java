package com.sprintforge.scrum.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = "com.sprintforge")
@ConfigurationPropertiesScan(basePackages = "com.sprintforge")
public class ScrumActivityApplication {

    static void main(String[] args) {
        SpringApplication.run(ScrumActivityApplication.class, args);
    }

}
