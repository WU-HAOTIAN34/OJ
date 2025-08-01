package com.wht.oj2025;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wht.oj2025.mapper")
@EnableFeignClients
public class MainQuestion8011 {
    public static void main(String[] args) {
        SpringApplication.run(MainQuestion8011.class, args);
    }
}