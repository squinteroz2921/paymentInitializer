package com.co.bancolombia.paymentInitializer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.Id;

import java.io.Serializable;

@Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="accounts")
public class account implements Serializable {

    @Id
    @Column(name = "Id")
    public int id;
    @Column(name = "fk_client")
    public String fk_client;
    @Column(name = "account_type")
    public String account_type;
    @Column(name = "account_number")
    public String account_number;
    @Column(name = "status")
    public String status;
    @Column(name = "created_on")
    @CreatedDate
    public String created_on;


}