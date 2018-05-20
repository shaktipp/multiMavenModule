package com.spp.spring.boot.cloud.jpa.bank.customer.service;

import com.spp.spring.boot.cloud.jpa.bank.customer.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spp.spring.boot.cloud.jpa.bank.customer.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer prm_customer)
    {
        boolean result = false;

        try
        {
            logger.info("Customer ID(" + prm_customer.getCustomerId() + ") is added Sucessfully");
            return customerRepository.save(prm_customer);
        }
        catch(Exception exception)
        {
            logger.error("Unable to add Customer, Actual Error=" + exception.getMessage());
        }

        return null;
    }

    public Customer editCustomer(Customer prm_customer)
    {
        logger.info("Customer ID(" + prm_customer.getCustomerId() + ") is updated Sucessfully");
        return addCustomer(prm_customer);
    }

    public boolean deleteCustomer(String customerId)
    {
        try
        {
            Optional<Customer> customer = customerRepository.findById(customerId);
            if(customer.isPresent())
            {
                customerRepository.delete(customer.get());
                logger.info("Customer ID(" + customerId + ") found so Deleted Sucessfully");
                return true;
            }
            logger.warn("Customer ID(" + customerId + ") Not Found so unable to Delete customer");
            return false;
        }
        catch(Exception exception)
        {
            logger.error("Unable to delete Customer, Actual Error=" + exception.getMessage());
        }

        return false;
    }

    public List<Customer> findAllCustomer()
    {
        logger.info("Find All customer");
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(String prm_customerId)
    {
        logger.info("Find customer by CustomerID( "+ prm_customerId + ")");
        return customerRepository.findById(prm_customerId);
    }

}
