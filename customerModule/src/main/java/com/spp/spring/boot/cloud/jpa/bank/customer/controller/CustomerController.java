package com.spp.spring.boot.cloud.jpa.bank.customer.controller;

import com.spp.spring.boot.cloud.jpa.bank.customer.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.spp.spring.boot.cloud.jpa.bank.customer.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CustomerService customerService;

    @PostMapping(path = "/addCustomer", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Customer addCustomer(@RequestBody Customer prm_customer)
    {
        logger.info("Create Customer, Input Provided\n" + prm_customer);
        return customerService.addCustomer(prm_customer);
    }


    @PostMapping(path = "/editCustomer", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Customer editCustomer(@RequestBody Customer prm_customer)
    {
        logger.info("Edit Customer, Input Provided\n" + prm_customer);
        return customerService.editCustomer(prm_customer);
    }


    @DeleteMapping(path = "/deleteCustomer/{customerId}")
    public boolean deleteCustomer(@PathVariable String customerId)
    {
        logger.info("Delete Customer with CustomerID(" + customerId + ")\n");
        return customerService.deleteCustomer(customerId);
    }

    @GetMapping(path = "/findAllCustomer")
    public List<Customer> findAllCustomer()
    {
        return customerService.findAllCustomer();
    }


    @GetMapping(path = "/findCustomerById/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Customer findCustomerById(@PathVariable String customerId)
    {
        Optional<Customer> customer= customerService.findCustomerById(customerId);
        if(customer.isPresent())
        {
            logger.info("Customer  ID( "+customerId+ ") is available");
            return customer.get();
        }
        logger.warn("Customer  ID( "+customerId+ ") is not available");
        return null;
    }

}//End of class CustomerController
