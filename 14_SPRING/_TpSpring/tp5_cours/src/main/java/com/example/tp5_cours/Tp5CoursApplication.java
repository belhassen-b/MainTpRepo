package com.example.tp5_cours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Tp5CoursApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp5CoursApplication.class, args);
    }

}
