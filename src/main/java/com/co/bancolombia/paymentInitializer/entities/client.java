package com.co.bancolombia.paymentInitializer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


import java.sql.Date;


@Data
@Entity
@Table(name = "client")
public class client {
    @Id
    @Column(name = "Id")
    public int id;
    @Column(name = "document_number")
    public String document_number;
    @Column(name = "document_type")
    public String document_type;
    @Column(name = "name")
    public String name;
    @Column(name = "created_on")
    public Date created_on;
}
