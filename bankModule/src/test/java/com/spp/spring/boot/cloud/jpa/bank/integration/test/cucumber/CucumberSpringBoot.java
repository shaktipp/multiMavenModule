package com.spp.spring.boot.cloud.jpa.bank.integration.test.cucumber;

import com.spp.spring.boot.cloud.jpa.bank.BankApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;


@RunWith( SpringRunner.class )
@SpringBootTest( classes = BankApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@ContextConfiguration( classes = BankApplication.class )
public abstract class CucumberSpringBoot
{
    Logger           logger       = LoggerFactory.getLogger( CucumberSpringBoot.class );

    @Autowired
    TestRestTemplate restTemplate = new TestRestTemplate( );

    @Before
    public void before()
    {
        restTemplate.getRestTemplate( ).setInterceptors( Collections.singletonList( ( request, body, execution ) -> {
            return execution.execute( request, body );
        } ) );
    }

    @Test
    public void CucumberJunitTest()
    {
        System.out.println( "Cucumber JVM and Junit Sample Test" );
    }
}
