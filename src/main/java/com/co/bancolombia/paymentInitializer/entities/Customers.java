package com.co.bancolombia.paymentInitializer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "customers")
public class Customers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCustomer;

    @Column(name = "name")
    private String customerName;

    @Column(name = "document_type")
    private String customerDocType;
    @Column(name = "document_number")
    private String customerDocNumber;
    @Column(name = "account_type")
    private String customerAccountType;
    @Column(name = "account_number")
    private String customerAccount;
    @Column(name = "email")
    private String customerEmail;
    @Column(name = "phone_number")
    private String customerPhone;
    @Column(name = "address")
    private String customerAddress;
    @Column(name = "date_of_birth")
    private String customerBirth;

    @jakarta.persistence.Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date customerDate;
    @jakarta.persistence.Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_update")
    private Date customerUpdate;

    @PrePersist
    public void prePersist() {
        this.customerDate = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        this.customerUpdate = new Date();
    }

}
