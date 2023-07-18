package com.co.bancolombia.paymentInitializer.dto.transaction;

import lombok.*;

import java.sql.Date;

@Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class transactionRequest {
    public String id;
    public String fk_client;
    public String financialInstitutionCode;
    public String commerceCode;
    public String commerceUrl;
    public String serviceCode;
    public int transactionValue;
    public int vatValue;
    public String currency;
    public String ticketId;
    public String entityUrl;
    public Date soliciteDate;
    public String paymentDescription;
    public String referenceNumber1;
    public String referenceNumber2;
    public String referenceNumber3;
    public String indicator4per1000;
    public String beneficiaryEntityIdentificationType;
    public String beneficiaryEntityIdentification;
    public String beneficiaryEntityName;
    public String beneficiaryEntityCIIUCategory;
    public String trazabilityCode;
    public String transactionState;
    public String created_on;
    public String update_on;
}
