package com.spp.spring.boot.cloud.jpa.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spp.spring.boot.cloud.jpa.bank"})

public class BankApplication
{
    public static void main( String[ ] args )
    {
        SpringApplication.run( BankApplication.class, args );
    }
}
