package com.PaymentApplication.controller;

import com.PaymentApplication.entity.Account;
import com.PaymentApplication.request.PaymentRequest;
import com.PaymentApplication.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/paynow")
    public ResponseEntity<String> payNow(@RequestBody PaymentRequest paymentRequest) {
        Boolean status = paymentService.payNow(paymentRequest);
        return ResponseEntity.status(HttpStatus.OK).body(status ? "Payment Successful" : "Payment failed due to insufficient balance");
    }

    @GetMapping("/saveAccountDetail")
    public String saveAccountDetail() {
        paymentService.addData();
        return "data inserted";
    }

    @GetMapping("/getMasterdata")
    public List<Account> getMasterData() {
        List<Account> account = paymentService.getMasterData();
        return account;
    }

}
