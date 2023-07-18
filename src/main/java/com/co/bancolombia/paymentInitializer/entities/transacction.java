package com.co.bancolombia.paymentInitializer.entities;

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
    public class transaction {

        @Id
        @Column("id")
        public String id;
        @Column("fk_client")
        public String fk_client;
        @Column("financialInstitutionCode")
        public String financialInstitutionCode;
        @Column("commerceCode")
        public String commerceCode;
        @Column("commerceUrl")
        public String commerceUrl;
        @Column("serviceCode")
        public String serviceCode;
        @Column("transactionValue")
        public int transactionValue;
        @Column("vatValue")
        public int vatValue;
        @Column("currency")
        public String currency;
        @Column("ticketId")
        public String ticketId;
        @Column("entityUrl")
        public String entityUrl;
        @Column("soliciteDate")
        public Date soliciteDate;
        @Column("paymentDescription")
        public String paymentDescription;
        @Column("referenceNumber1")
        public String referenceNumber1;
        @Column("referenceNumber2")
        public String referenceNumber2;
        @Column("referenceNumber3")
        public String referenceNumber3;
        @Column("indicator4per1000")
        public String indicator4per1000;
        @Column("beneficiaryEntityIdentificationType")
        public String beneficiaryEntityIdentificationType;
        @Column("beneficiaryEntityIdentification")
        public String beneficiaryEntityIdentification;
        @Column("beneficiaryEntityName")
        public String beneficiaryEntityName;
        @Column("beneficiaryEntityCIIUCategory")
        public String beneficiaryEntityCIIUCategory;
        @Column("trazabilityCode")
        public String trazabilityCode;
        @Column("transactionState")
        public String transactionState;
        @Column("created_on")
        @CreatedDate
        public String created_on;
        @Column("update_on")
        @LastModifiedDate
        public String update_on;

}
