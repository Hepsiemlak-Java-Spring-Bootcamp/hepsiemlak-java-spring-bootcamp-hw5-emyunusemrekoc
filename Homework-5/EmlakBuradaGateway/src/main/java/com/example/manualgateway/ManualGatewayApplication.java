package main.java.com.example.manualgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ManualGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManualGatewayApplication.class, args);
    }

}
