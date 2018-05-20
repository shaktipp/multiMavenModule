package com.spp.spring.boot.cloud.jpa.bank.service;


import com.spp.spring.boot.cloud.jpa.bank.model.Bank;
import com.spp.spring.boot.cloud.jpa.bank.model.Branch;
import com.spp.spring.boot.cloud.jpa.bank.repository.BranchRepository;
import com.spp.spring.boot.cloud.jpa.bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankService
{
    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BankRepository bankRepository ;

    public Bank insertBank(Bank bank)
    {
        return bankRepository.save(bank);
    }

    public boolean deleteBank(String bankId)
    {
        Optional<Bank> bank = bankRepository.findById(bankId);
        if(bank.isPresent()) {
            bankRepository.deleteById(bankId);
            return true;
        }
        return false;
    }

    public List<Bank> findAllBank()
    {
        return bankRepository.findAll();
    }

    public Optional<Bank> findBankById(String bankId)
    {
        return bankRepository.findById(bankId);
    }

    //////////////////////////////////////////////////////BRANCH OF BANK SERVICE //////////////////////////////////////////
    public Branch insertBranch(Branch branch)
    {
        return branchRepository.save(branch);
    }

    public List<Bank> findAllBranches()
    {
        //System.out.println("Fina All Branches\n" + bankRepository.findAllBranch());
        /*List<Bank> bank_list = bankRepository.findAllBranch();
        List<Branch> branch_list = new ArrayList<>();

        for(Bank bank : bank_list)
            branch_list.addAll(bank.getBranches());
        return branch_list;*/
        return bankRepository.findAllBranch();
    }


}//End of class BankService
