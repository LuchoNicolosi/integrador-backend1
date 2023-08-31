package com.grupo4.integrador;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegradorApplication {

    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        SpringApplication.run(IntegradorApplication.class, args);
    }

}
