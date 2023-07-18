package com.co.bancolombia.paymentInitializer.dto.accounts;

import lombok.*;

@Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class accountsDTO {
    public String id;
    public String fk_client;
    public String account_type;
    public String account_number;
    public String status;
    public String created_on;
    public String update_on;
}
