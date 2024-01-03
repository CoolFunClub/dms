package com.coolfunclub.dms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coolfunclub.dms.model.Account;
import com.coolfunclub.dms.model.Manager;
import com.coolfunclub.dms.service.ManagerService;
import com.coolfunclub.dtos.AccountDTO;

@RestController
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @PostMapping(value = "/manager")
    public ResponseEntity<String> addManager(@RequestBody Manager manager){
        return managerService.addManager(manager);
    }

    @GetMapping(value = "/manager")
    public List<Manager> getManagers(){
        return managerService.getAllManagers();
    }

    @GetMapping(value = "/manager/{ssn}")
    public Manager getManagerById(@PathVariable("ssn") long ssn ){
        return managerService.getManagerById(ssn);
    }

    @DeleteMapping(value = "/manager/{ssn}")
    public void deleteManager(@PathVariable("ssn") long ssn ){
        managerService.deleteManager(ssn);
    }

    @PutMapping(value = "/manager/{ssn}")
    public void updateManager(@PathVariable long ssn, @RequestBody Manager manager){
        manager.setSSN(ssn);
        managerService.updateManager(manager);
    }



}
