package com.wht.oj2025;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
public class MainCodeSandBox8031 {
    public static void main(String[] args) {
        SpringApplication.run(MainCodeSandBox8031.class, args);
    }
}