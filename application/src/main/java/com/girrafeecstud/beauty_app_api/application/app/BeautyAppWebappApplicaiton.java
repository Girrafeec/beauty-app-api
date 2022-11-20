package com.girrafeecstud.beauty_app_api.application.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.girrafeecstud")
public class BeautyAppWebappApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(BeautyAppWebappApplicaiton.class, args);
    }

}
