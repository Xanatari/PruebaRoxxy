package com.neivor.prueba.roxxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableRetry
public class PruebaNeivorRoxxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaNeivorRoxxyApplication.class, args);
    }

}
