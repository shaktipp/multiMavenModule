package com.spp.spring.boot.cloud.jpa.bank.integration.test.cucumber;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spp.spring.boot.cloud.jpa.bank.model.Bank;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class BankCucumberTest extends CucumberSpringBoot
{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static ResponseEntity<Bank> responseEntity = null;

    @When("^the client submit  POST Request to \"([^\"]*)\" body as JSON$")
    public void the_client_submit_POST_Request_to_body_as_JSON(String restUrl, String jsonBody) throws Throwable
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
            logger.info( "Request Body for POST Request\n" + jsonNodeInput.get( 0 ).toString( ) + "\n");
            responseEntity = restTemplate.postForEntity( restUrl, httpEntity,Bank.class );

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
    public void receive_HTTP_Status_code_of_POST_Operation_is(int statusCode) throws Throwable
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

    @Then("^response body contains following JSON$")
    public void response_body_contains_following_JSON(String expectedJsonOutput) throws Throwable
    {
        //String lv_jsonResponse = null;
        ObjectMapper objectMapper = null;
        JsonNode jsonOutputNode = null;
        JsonNode jsonExpectedNode = null;

        Bank lv_response_bank = null;
        Bank lv_outputProvided_bank = null;
        try
        {
            lv_response_bank = responseEntity.getBody( );
            objectMapper = new ObjectMapper();
            lv_outputProvided_bank = objectMapper.readValue(expectedJsonOutput, Bank.class);

            logger.info( "Actual Output\n" + lv_response_bank + "\nExpected Output Provided\n" + lv_outputProvided_bank);
            assertEquals( "Expect Output does not match with Actual Output : " ,lv_outputProvided_bank.toString(), lv_response_bank.toString());

        }
        catch(Exception exception)
        {
            logger.error( "Error Found :" + exception.getMessage( ) );
            exception.printStackTrace();
            //throw new PendingException( exception.getMessage( ));
        }
        finally
        {

            /*objectMapper = null;
            jsonOutputNode = null;
            jsonExpectedNode = null;*/
        }


    }
}
