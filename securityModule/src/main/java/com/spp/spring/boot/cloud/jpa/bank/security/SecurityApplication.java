package com.spp.spring.boot.cloud.jpa.bank.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spp.spring.boot.cloud.jpa.bank.security"})
public class SecurityApplication
{
    public static void main( String[ ] args )
    {
        SpringApplication.run( SecurityApplication.class, args );
    }
}
