package com.spp.spring.boot.cloud.jpa.bank.security.service;

import com.spp.spring.boot.cloud.jpa.bank.security.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spp.spring.boot.cloud.jpa.bank.security.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    public User addUser(User prm_user)
    {
        logger.info("User ID(" + prm_user.getUserId() + ") is added sucessfully");
        return userRepository.save(prm_user);
    }

    public User editUser(User prm_user)
    {
        logger.info("User ID(" + prm_user.getUserId() + ") is updated sucessfully");
        return userRepository.save(prm_user);
    }

    public boolean deleteUser(String prm_userId)
    {
        Optional<User> user = userRepository.findById(prm_userId);

        if(user.isPresent())
        {
            userRepository.deleteById(prm_userId);
            logger.info("User ID(" + prm_userId + ") is deleted sucessfully");
            return true;
        }
        logger.info("User ID(" + prm_userId + ") is not found so unable to delete the User");
        return false;

    }


    public List<User> findAllUser()
    {
        logger.info("Find All User Information");
        return userRepository.findAll();
    }


    public User findUserById(String prm_userId)
    {
        Optional<User> user = userRepository.findById(prm_userId);

        if(user.isPresent())
        {
            logger.info("User ID(" + prm_userId + ") is found sucessfully");
            return user.get();
        }
        logger.info("User ID(" + prm_userId + ") is not found ");
        return null;

    }
}//End of class UserService
