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
import com.coolfunclub.dms.model.Payment;
import com.coolfunclub.dms.service.PaymentService;

@RestController
/* @RequestMapping("cfc/") */
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    // Addign a Cash Payment
    @PostMapping(value = "addcashpay/{id}")
    public ResponseEntity<String> addCashPayment(@RequestBody Payment payment, @PathVariable ("id") Long purId){
        return paymentService.addCashPayment(payment,purId);
    }

    // Adding a Card Payment
    @PostMapping(value = "addcardpay/{purid}/{cardid}")
    public ResponseEntity<String> addCardPayment(
        @RequestBody Payment payment,
        @PathVariable ("purid") Long purId,
        @PathVariable ("cardid") Long cardNum){

        return paymentService.addCardPayment(payment,purId,cardNum);
    }

    @GetMapping(value = "payment")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping(value = "payment/{id}")
    public Payment getPaymentByID(@PathVariable("id") Long paymentID ) {
        return paymentService.getPaymentById(paymentID);
    }

    @DeleteMapping(value = "payment/{id}")
    public void deletePaymentByID(@PathVariable("id") Long paymentID ) {
        paymentService.deletePaymentById(paymentID);
    }

}
