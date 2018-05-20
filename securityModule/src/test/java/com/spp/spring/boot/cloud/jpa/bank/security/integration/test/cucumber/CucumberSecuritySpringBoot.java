package com.spp.spring.boot.cloud.jpa.bank.security.integration.test.cucumber;

import com.spp.spring.boot.cloud.jpa.bank.security.SecurityApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith( SpringRunner.class )
@SpringBootTest( classes = SecurityApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@ContextConfiguration( classes = SecurityApplication.class )
public class CucumberSecuritySpringBoot
{
    Logger logger       = LoggerFactory.getLogger( SecurityApplication.class );

    @Autowired
    TestRestTemplate restTemplate = new TestRestTemplate( );

    @Before
    public void beforeIntegrationTest()
    {
        restTemplate.getRestTemplate( ).setInterceptors( Collections.singletonList( (request, body, execution ) -> {
            return execution.execute( request, body );
        } ) );
    }

    @Test
    public void CucumberSecurityJunitTest()
    {
        System.out.println( "Cucumber JVM and Junit Sample Test for Customer Module" );
    }
}
