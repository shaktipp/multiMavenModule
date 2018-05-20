package com.spp.spring.boot.cloud.jpa.bank.customer.repository;

import com.spp.spring.boot.cloud.jpa.bank.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends MongoRepository<Customer,String>
{
}
