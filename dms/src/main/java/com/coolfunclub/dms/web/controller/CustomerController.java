package com.coolfunclub.dms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.coolfunclub.dms.model.Customer;
import com.coolfunclub.dms.repository.CustomerRepository;
import com.coolfunclub.dms.service.CustomerService;

@CrossOrigin(origins = {"http://localhost:3000", "http://18.117.76.202:3000"})
@RestController
@RequestMapping("cfc/")
public class CustomerController {

  @Autowired
  CustomerService customerService;
  //CustomerRepository customerRepository;

  @PostMapping(value = "addcustomers")
  public ResponseEntity<String> addCustomer(@RequestBody Customer customer ){
    return customerService.addCustomer(customer);
}

@GetMapping(value = "customers")
public List<Customer> getCustomers(){
    return customerService.getAllCustomers();
}

@GetMapping(value = "/customers/{id}")
public Customer getCustomerById(@PathVariable("id") String driverLic ){
    return customerService.getCustomerById(driverLic);
}

@DeleteMapping(value = "/customers/{id}")
public void deleteCustomerById(@PathVariable("id") String driverLic ){
    customerService.deleteCustomer(driverLic);
}

@PutMapping(value = "/customers/{driverLic}")
public void updateCustomer(@PathVariable String driverLic, @RequestBody Customer customer){
    customer.setDriverLicenseID(driverLic);
    customerService.updateCustomer(customer);
}
}
