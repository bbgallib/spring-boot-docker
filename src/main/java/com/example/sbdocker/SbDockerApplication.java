package com.example.sbdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.sbdocker.infrastructure.mapper")
public class SbDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbDockerApplication.class, args);
    }

}
