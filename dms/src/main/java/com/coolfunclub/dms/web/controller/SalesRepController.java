package com.coolfunclub.dms.web.controller;

import com.coolfunclub.dms.model.Account;
import com.coolfunclub.dms.model.SalesRep;
import com.coolfunclub.dms.service.SalesRepService;
import com.coolfunclub.dtos.AccountDTO;

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
import com.coolfunclub.dtos.AccountDTO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
/* @RequestMapping("cfc/") */
public class SalesRepController {

    @Autowired
    SalesRepService salesRepService;

    @PostMapping(value = "/rep")
    public ResponseEntity<String> addSalesRep(@RequestBody SalesRep salesRep){
        return salesRepService.addSalesRep(salesRep);
    }

    @GetMapping(value = "/rep")
    public List<SalesRep> getSalesReps(){
        return salesRepService.getAllSalesReps();
    }

    @GetMapping(value = "/rep/{ssn}")
    public SalesRep getSalesRep(@PathVariable("ssn") long ssn ){
        return salesRepService.getSalesRepById(ssn);
    }

    @DeleteMapping(value = "/rep/{ssn}")
    public void deleteManagerById(@PathVariable("ssn") long ssn ){
        salesRepService.deleteSalesRep(ssn);
    }

    @PutMapping(value = "/rep/{ssn}")
    public void updateSalesRep(@PathVariable long ssn, @RequestBody SalesRep salesRep ){
        salesRep.setSSN(ssn);
        //salesRep.setId(id);
        salesRepService.updateSalesRep(salesRep);
    }

}
