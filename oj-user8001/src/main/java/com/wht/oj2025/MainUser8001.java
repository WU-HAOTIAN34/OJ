package com.wht.oj2025;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("com.wht.oj2025.mapper")
public class MainUser8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainUser8001.class, args);
    }
}