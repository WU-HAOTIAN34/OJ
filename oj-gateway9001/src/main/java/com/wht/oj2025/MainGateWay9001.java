package com.wht.oj2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MainGateWay9001 {
    public static void main(String[] args) {
        SpringApplication.run(MainGateWay9001.class, args);
    }
}