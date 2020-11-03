package com.eli.fullweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullwebApplication.class, args);
        System.out.println("IoC Container is on!");
    }

}
