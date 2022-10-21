package com.openkey.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAutomationApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringBootAutomationApplication.class,args);
        }catch (Throwable e){
            e.printStackTrace();
        }

    }
}
