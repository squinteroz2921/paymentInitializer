package com.co.bancolombia.paymentInitializer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.*;
import java.sql.Date;

    @Data
    @ToString
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="hackaton.transacction")
    public class transacction {

        @Id
        @Column(name = "id")
        public String id;
        @Column(name = "fk_client")
        public String fk_client;
        @Column(name = "financialInstitutionCode")
        public String financialInstitutionCode;
        @Column(name = "commerceCode")
        public String commerceCode;
        @Column(name = "commerceUrl")
        public String commerceUrl;
        @Column(name = "serviceCode")
        public String serviceCode;
        @Column(name = "transactionValue")
        public int transactionValue;
        @Column(name = "vatValue")
        public int vatValue;
        @Column(name = "currency")
        public String currency;
        @Column(name = "ticketId")
        public String ticketId;
        @Column(name = "entityUrl")
        public String entityUrl;
        @Column(name = "soliciteDate")
        public Date soliciteDate;
        @Column(name = "paymentDescription")
        public String paymentDescription;
        @Column(name = "referenceNumber1")
        public String referenceNumber1;
        @Column(name = "referenceNumber2")
        public String referenceNumber2;
        @Column(name = "referenceNumber3")
        public String referenceNumber3;
        @Column(name = "indicator4per1000")
        public String indicator4per1000;
        @Column(name = "beneficiaryEntityIdentificationType")
        public String beneficiaryEntityIdentificationType;
        @Column(name = "beneficiaryEntityIdentification")
        public String beneficiaryEntityIdentification;
        @Column(name = "beneficiaryEntityName")
        public String beneficiaryEntityName;
        @Column(name = "beneficiaryEntityCIIUCategory")
        public String beneficiaryEntityCIIUCategory;
        @Column(name = "trazabilityCode")
        public String trazabilityCode;
        @Column(name = "transactionState")
        public String transactionState;
        @Column(name = "created_on")
        @CreatedDate
        public String created_on;
        @Column(name = "update_on")
        @LastModifiedDate
        public String update_on;

}
