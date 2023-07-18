package com.co.bancolombia.paymentInitializer.dto.client;


import lombok.*;

@Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class clientDTO {
    public String id;
    public String document_number;
    public String document_type;
    public String name;
    public Date created_on;
}

