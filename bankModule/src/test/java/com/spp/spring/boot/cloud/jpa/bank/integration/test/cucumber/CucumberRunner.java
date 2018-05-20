package com.spp.spring.boot.cloud.jpa.bank.integration.test.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-reports", "json:target/cucumber.json"}, features = {"src/test/resources/features"})
public class CucumberRunner
{
}
