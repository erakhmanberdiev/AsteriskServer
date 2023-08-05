package com.example.asteriskserver;

import com.example.asteriskserver.FeignClients.AsteriskARI.Applications;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AsteriskServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsteriskServerApplication.class, args);

    }

}



