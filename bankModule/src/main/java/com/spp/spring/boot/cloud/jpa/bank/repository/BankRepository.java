package com.spp.spring.boot.cloud.jpa.bank.repository;

import com.spp.spring.boot.cloud.jpa.bank.model.Bank;
import com.spp.spring.boot.cloud.jpa.bank.model.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends MongoRepository <Bank,String>
{
    //@Query(value= "{'branches' : {{$exists:true}}", fields="{_id : 0, branches : 1}")
    @Query(value= "{'branches' : {{$exists:true}}")
    public List<Bank> findAllBranch();
}
