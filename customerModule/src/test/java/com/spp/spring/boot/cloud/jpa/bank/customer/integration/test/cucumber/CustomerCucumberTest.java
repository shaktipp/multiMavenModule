package com.spp.spring.boot.cloud.jpa.bank.customer.integration.test.cucumber;

import com.spp.spring.boot.cloud.jpa.bank.customer.model.Customer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;

import static org.junit.Assert.assertEquals;

public class CustomerCucumberTest extends CucumberCustomerSpringBoot
{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static ResponseEntity<Customer> responseEntity = null;

    @When("^the client submit  POST Request to \"([^\"]*)\" to create new Customer with following JSON as input$")
    public void the_client_submit_POST_Request_to_to_create_new_Customer_with_following_JSON_as_input(String restUrl, String jsonBody)
    {
        ObjectMapper objectMapper = null;
        HttpHeaders headers = null;
        HttpEntity<String> httpEntity = null;

        try
        {
            logger.info( "Input Provided, REST URL =" + restUrl + " ,jsonBody = " + jsonBody);
            objectMapper = new ObjectMapper();
            JsonNode jsonNodeInput = objectMapper.readTree( jsonBody.getBytes( ) );
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            httpEntity = new HttpEntity<>(jsonNodeInput.get( 0 ).toString( ), headers);
            logger.info( "Request Body for POST Request to Create Customer\n" + jsonNodeInput.get( 0 ).toString( ) + "\n");
            responseEntity = restTemplate.postForEntity( restUrl, httpEntity,Customer.class );

            logger.info( "Response Found\n" + responseEntity.getBody( ) + "\n");

            assertEquals( "Response is incorrect : " + responseEntity.getBody( ), responseEntity.getBody( ).toString().length() > 1, true );

        }
        catch(Exception exception)
        {
            logger.error( "Error Found :" + exception.getMessage( ) );
            throw new PendingException( exception.getMessage( ));
        }
        finally
        {
            objectMapper = null;
            headers = null;
            httpEntity = null;
        }

    }

    @Then("^receive HTTP Status code of POST Operation is (\\d+)$")
    public void receive_HTTP_Status_code_of_POST_Operation_is(int statusCode)
    {
        HttpStatus lv_currentStatusCode = null;
        try
        {
            lv_currentStatusCode = responseEntity.getStatusCode( );
            logger.info( "Input Provided statusCode=" + statusCode + " , Actual Status Code found=" + lv_currentStatusCode.value( ) );
            assertEquals( "HTTP Response Status code is incorrect : " + lv_currentStatusCode , lv_currentStatusCode.value( ),statusCode  );

        }
        catch(Exception exception)
        {
            logger.error( "Error Found :" + exception.getMessage( ) );
            throw new PendingException( exception.getMessage( ));
        }
        finally
        {
            lv_currentStatusCode = null;
        }
    }

    @Then("^response body contains following JSON if Customer is created$")
    public void response_body_contains_following_JSON_if_Customer_is_created(String expectedJsonOutput)
    {
        ObjectMapper objectMapper = null;
        Customer lv_response_customer = null;
        Customer[] lv_outputProvided_customer_arr = null;
        try
        {
            lv_response_customer = responseEntity.getBody( );
            objectMapper = new ObjectMapper();
            logger.info("Expected JSON provided in Feature File\n" + expectedJsonOutput);
            lv_outputProvided_customer_arr = objectMapper.readValue(expectedJsonOutput, Customer[].class);

            logger.info( "Actual Output\n" + lv_response_customer + "\nExpected Output Provided\n" + lv_outputProvided_customer_arr[0]);
            assertEquals( "Expect Output does not match with Actual Output : " ,lv_outputProvided_customer_arr[0].toString(), lv_response_customer.toString());

        }
        catch(Exception exception)
        {
            logger.error( "Error Found :" + exception.getMessage( ) );
            exception.printStackTrace();
            throw new PendingException( exception.getMessage( ));
        }
        finally
        {
            lv_response_customer = null;
            //lv_outputProvided_customer = null;
            objectMapper = null;
        }
    }
}
