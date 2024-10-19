package com.PaymentApplication.service;

import com.PaymentApplication.entity.Account;
import com.PaymentApplication.repository.AccountRepository;
import com.PaymentApplication.request.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    AccountRepository accountRepository;


    public Boolean payNow(PaymentRequest paymentRequest) {

        Account account = accountRepository.findByUpiNo(paymentRequest.getPhoneNumber());
        Long remainingBalance = account.getAccountBalance() - paymentRequest.getAmount();
        if (remainingBalance >= 0d) {
            account.setAccountBalance(remainingBalance);
            accountRepository.save(account);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void addData() {

        List<Account> accounts = new ArrayList<>();

        // Insert 15 accounts with similar data
        for (long i = 1; i <= 15; i++) {
            Account account = new Account(1234556L + i, 3400L * i);  // Similar data, but unique UPI No.
            accounts.add(account);
        }
        accountRepository.deleteAll();
        accountRepository.saveAll(accounts);
    }

    public List<Account> getMasterData() {
        return accountRepository.findAll();
    }
}
