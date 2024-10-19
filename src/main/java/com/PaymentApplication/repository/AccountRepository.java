package com.PaymentApplication.repository;

import com.PaymentApplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUpiNo(BigInteger phoneNumber);
}
