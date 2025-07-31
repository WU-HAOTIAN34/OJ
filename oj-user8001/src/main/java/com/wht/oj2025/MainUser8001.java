package com.wht.oj2025;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication(scanBasePackages = "com.wht")
@MapperScan("com.wht.oj2025.mapper")
@EnableDiscoveryClient
//@EnableFeignClients
public class MainUser8001 {
    public static void main(String[] args) {
        SpringApplication.run(MainUser8001.class, args);
    }
}