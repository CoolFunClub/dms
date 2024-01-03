package com.coolfunclub.dms.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coolfunclub.dms.model.Account;
import com.coolfunclub.dms.model.SalesRep;
import com.coolfunclub.dms.repository.SalesRepRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SalesRepService {

    @Autowired
    SalesRepRepository salesRepRepository;
    @Autowired
    AccountService accountService;

    //Constructor
    public SalesRepService(){

    }

    public ResponseEntity<String> addSalesRep(SalesRep salesRep){
        Optional <SalesRep> existingSalesRep = salesRepRepository.findById(salesRep.getSSN());
        if (existingSalesRep.isPresent()){
            return ResponseEntity.badRequest().body("SalesRep already exists with the provided SSN.");
        } else{

         salesRepRepository.save(salesRep);
         return ResponseEntity.ok("SalesRep added successfully");
        }
    }

    public List<SalesRep> getAllSalesReps(){
        List<SalesRep> salesReps = new LinkedList<>();
        salesRepRepository.findAll().forEach(salesReps::add);
        return salesReps;
    }

    public void deleteSalesRep(long ssn){
            salesRepRepository.deleteById(ssn);
    }

    public SalesRep getSalesRepById(long ssn){
        return salesRepRepository.findById(ssn).orElse(null);
    }


    public void updateSalesRep(SalesRep newSalesRep){
        salesRepRepository.save(newSalesRep);
    }
    public SalesRep associateAccountToSalesRep(long ssn, Account account) {
        System.out.println(account.toString());
        SalesRep salesRep = salesRepRepository.findById(ssn).orElse(null);
        salesRep.setAccount(accountService.addAccount(account));
        return salesRepRepository.save(salesRep);
    }
}
