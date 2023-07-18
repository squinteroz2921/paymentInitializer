package com.co.bancolombia.paymentInitializer.dto.customers;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomersRequest implements Serializable {

    private String customerName;
    private String customerDocType;
    private String customerDocNumber;
    private String customerAccountType;
    private String customerAccount;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    private String customerBirth;
}
