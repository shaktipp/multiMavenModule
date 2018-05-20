package com.spp.spring.boot.cloud.jpa.bank.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.spp.spring.boot.cloud.jpa.bank"})
public class CustomerApplication
{
    public static void main( String[ ] args )
    {
        SpringApplication.run( CustomerApplication.class, args );
    }
}
