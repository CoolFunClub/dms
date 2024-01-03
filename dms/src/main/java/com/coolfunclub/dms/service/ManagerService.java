package com.coolfunclub.dms.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coolfunclub.dms.model.Account;
import com.coolfunclub.dms.model.Manager;
import com.coolfunclub.dms.model.SalesRep;
import com.coolfunclub.dms.repository.ManagerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    AccountService accountService;

    //Constructor
    public ManagerService(){

    }

    public ResponseEntity<String> addManager(Manager manager){
        Optional <Manager> existingManager = managerRepository.findById(manager.getSSN());
        if(existingManager.isPresent()){
            return ResponseEntity.badRequest().body("Manager already exists with the provided SSN.");
        }
       managerRepository.save(manager);
       return ResponseEntity.ok("Manager added successfully");
    }

    public List<Manager> getAllManagers(){
        List<Manager> Managers = new LinkedList<>();
        managerRepository.findAll().forEach(Managers::add);
        return Managers;
    }

    public void deleteManager(long ssn){
        managerRepository.deleteById(ssn);
    }

    public Manager getManagerById(long ssn){
        return managerRepository.findById(ssn).orElse(null);
    }

    public void updateManager(Manager newManager){
        managerRepository.save(newManager);
    }

    public Manager associateAccountToManager(long ssn, Account account) {
        System.out.println(account.toString());
        Manager manager = managerRepository.findById(ssn).orElse(null);
        manager.setAccount(accountService.addAccount(account));
        return managerRepository.save(manager);
    }
}
