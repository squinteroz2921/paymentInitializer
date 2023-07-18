package com.co.bancolombia.paymentInitializer.entities;

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
    @Column("id")
    public String id;
    @Column("fk_client")
    public String fk_client;
    @Column("account_type")
    public String account_type;
    @Column("account_number")
    public String account_number;
    @Column("status")
    public String status;
    @Column("created_on")
    @CreatedDate
    public String created_on;


}