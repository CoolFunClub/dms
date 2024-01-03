package com.coolfunclub.dms.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coolfunclub.dms.model.Account;

import com.coolfunclub.dms.model.Account;
import com.coolfunclub.dms.model.Customer;
import com.coolfunclub.dms.model.Manager;
import com.coolfunclub.dms.repository.CustomerRepository;


import jakarta.persistence.EntityNotFoundException;
import lombok.ToString;
@ToString
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountService accountService;

    //Constructor
    public CustomerService(){

    }

    public ResponseEntity<String> addCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getDriverLicenseID());
        if (existingCustomer.isPresent()){
            return ResponseEntity.badRequest().body("Customer already exists with the provided driver license ID.");
        } else{
        customerRepository.save(customer);
        return ResponseEntity.ok("Customer added successfully");
        }
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new LinkedList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public void deleteCustomer(String driverLicenseID) {
        customerRepository.deleteById(driverLicenseID);
    }

    public Customer getCustomerById(String driverLicenseID) {
        return customerRepository.findById(driverLicenseID).orElse(null);
    }

    public void updateCustomer(Customer updatedCustomer) {
            customerRepository.save(updatedCustomer);
    }

     public Customer associateAccountToCustomer(String driverLicenseID, Account account) {
        System.out.println(account.toString());
        Customer customer = customerRepository.findById(driverLicenseID).orElse(null);
        customer.setAccount(accountService.addAccount(account));
        return customerRepository.save(customer);
    }
}
