package com.spp.spring.boot.cloud.jpa.bank.security.controller;

import com.spp.spring.boot.cloud.jpa.bank.security.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import com.spp.spring.boot.cloud.jpa.bank.security.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @PostMapping(path = "/addUser", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User addUser(@RequestBody User prm_user)
    {
        logger.info("Create New User, Input Provided\n" + prm_user);
        return userService.addUser(prm_user);
    }

    @PostMapping(path = "/editUser", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User editUser(@RequestBody User prm_user)
    {
        logger.info("Update Existing User, Input Provided\n" + prm_user);
        return userService.editUser(prm_user);
    }

    @DeleteMapping(path = "/deleteUser/{userId}")
    public String deleteUser(@PathVariable String userId)
    {
        logger.info("Delete User, Input Provided\n" + userId);
        boolean result = userService.deleteUser(userId);

        if(result)
            return userId + " is deleted Sucessfully";

        return userId + " Not Found so unable to delete";
    }

    @GetMapping(path = "/findAllUser")
    public List<User> findAllUser()
    {
        logger.info("Find All User Information");
        return userService.findAllUser();
    }

    @GetMapping(path = "/{findUserById}")
    public User findUserById(@PathVariable String findUserById )
    {
        logger.info("Find User Information with UserId(" + findUserById + ")");
        return userService.findUserById(findUserById);
    }

}//End of class UserController
