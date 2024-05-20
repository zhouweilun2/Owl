package com.web.web_spingboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.web.web_spingboot.mapper")
public class  WebSpingbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSpingbootApplication.class, args);
    }

}
