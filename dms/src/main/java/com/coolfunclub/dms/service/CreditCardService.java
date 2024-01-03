package com.coolfunclub.dms.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coolfunclub.dms.model.CreditCard;
import com.coolfunclub.dms.model.Customer;
import com.coolfunclub.dms.model.Manager;
import com.coolfunclub.dms.model.SalesRep;
import com.coolfunclub.dms.repository.CreditCardRepository;
import com.coolfunclub.dms.repository.CustomerRepository;
import com.coolfunclub.dms.repository.ManagerRepository;
import com.coolfunclub.dms.repository.SalesRepRepository;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    SalesRepRepository salesRepRepository;

    public ResponseEntity<String> addCard(CreditCard creditCard, String id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        Optional<Manager> managerOptional = managerRepository.findById(Long.parseLong(id));
        Optional<SalesRep> salesRepOptional = salesRepRepository.findById(Long.parseLong(id));

        if(customerOptional.isPresent()){
            Customer myCustomer = customerOptional.get();
            creditCard.setCustomer(myCustomer);
            creditCardRepository.save(creditCard);
            return ResponseEntity.ok("Customer Payment Card is added successfully");
        }else if(managerOptional.isPresent()){
            Manager myManager = managerOptional.get();
            creditCard.setManager(myManager);
            creditCardRepository.save(creditCard);
            return ResponseEntity.ok("Manager Payment Card is added successfully");
        }else if(salesRepOptional.isPresent()){
            SalesRep mySalesRep = salesRepOptional.get();
            creditCard.setSalesRep(mySalesRep);
            creditCardRepository.save(creditCard);
            return ResponseEntity.ok("SalesRep Payment Card is added successfully");
        }else{
            return ResponseEntity.badRequest().body("No Account associated with the provided data.");
        }
    }

    public List<CreditCard> getAllCards(){
        return creditCardRepository.findAll();
    }

    public CreditCard getCardById(Long cardNum){
        return creditCardRepository.findById(cardNum).orElse(null);
    }

    public void deleteCardById(Long cardNum) {
        creditCardRepository.deleteById(cardNum);
    }

}
