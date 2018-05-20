package com.spp.spring.boot.cloud.jpa.bank.security.repository;

import com.spp.spring.boot.cloud.jpa.bank.security.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User,String>
{
}
