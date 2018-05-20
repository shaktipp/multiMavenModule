package com.spp.spring.boot.cloud.jpa.bank.controller;

import com.spp.spring.boot.cloud.jpa.bank.model.Bank;
import com.spp.spring.boot.cloud.jpa.bank.model.Branch;
import com.spp.spring.boot.cloud.jpa.bank.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BankService bankService;

    /*@PostMapping(path = "/addBranch", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Branch addBranch(@RequestBody Branch prm_branch)
    {
        logger.info("Create Branch, Input Provided\n" + prm_branch);
        return bankService.insertBranch(prm_branch);
    }*/

    @PostMapping(path = "/addBank", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Bank addBank(@RequestBody Bank prm_bank)
    {
        logger.info("Create Branch, Input Provided\n" + prm_bank);
        return bankService.insertBank(prm_bank);
    }

    @DeleteMapping(path = "/deleteBank/{bankId}")
    public String deleteBank(@PathVariable String bankId)
    {
        logger.info("Delete Bank, Input Provided\n" + bankId);
        boolean result = bankService.deleteBank(bankId);
        if(result)
            return bankId + " is deleted Sucessfully";
        return bankId + " Not Found so unable to delete";
    }

    @GetMapping(path = "/findAllBank")
    public List<Bank> findAllBank()
    {
        return bankService.findAllBank();
    }

    /*@GetMapping(path = "/findAllBranches")
    public List<Bank> findAllBranches()
    {
        return bankService.findAllBranches();
    }*/
}
