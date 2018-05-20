package com.spp.spring.boot.cloud.jpa.bank.repository;

import com.spp.spring.boot.cloud.jpa.bank.model.Branch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends MongoRepository <Branch,String>
{
}
