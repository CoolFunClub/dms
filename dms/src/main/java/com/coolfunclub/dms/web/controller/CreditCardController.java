package com.coolfunclub.dms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coolfunclub.dms.model.CreditCard;
import com.coolfunclub.dms.service.CreditCardService;

@RestController
/* @RequestMapping("cfc/") */
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @PostMapping(value = "addcard/{id}")
    public ResponseEntity<String> addCard(@RequestBody CreditCard creditCard, @PathVariable ("id") String personId){
        return creditCardService.addCard(creditCard, personId);
    }

    @GetMapping(value = "card")
    public List<CreditCard> getAllCards() {
        return creditCardService.getAllCards();
    }

    @GetMapping(value = "card/{id}")
    public CreditCard getCardByID(@PathVariable("id") Long cardNum) {
        return creditCardService.getCardById(cardNum);
    }

    @DeleteMapping(value = "card/{id}")
    public void deleteCardByID(@PathVariable("id") Long cardNum) {
        creditCardService.deleteCardById(cardNum);
    }
}
