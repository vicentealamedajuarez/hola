package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.demo.repository")
public class DemoApplication {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/hola");
        SpringApplication.run(DemoApplication.class, args);
    }

}
