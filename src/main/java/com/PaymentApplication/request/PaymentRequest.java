package com.PaymentApplication.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    BigInteger phoneNumber;
    Long amount;
}


