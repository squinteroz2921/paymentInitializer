package com.co.bancolombia.paymentInitializer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

@Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hackaton.accounts")
public class account {

    @Id
    @Column(name = "id")
    public String id;
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