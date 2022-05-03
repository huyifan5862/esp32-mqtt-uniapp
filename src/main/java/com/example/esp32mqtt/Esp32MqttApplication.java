package com.example.esp32mqtt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.esp32mqtt.mapper")
public class Esp32MqttApplication {

    public static void main(String[] args) {
        SpringApplication.run(Esp32MqttApplication.class, args);
        System.out.println();
    }


}
