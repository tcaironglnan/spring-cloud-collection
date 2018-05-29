package com.turbline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class TurblineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurblineApplication.class, args);
    }
}
