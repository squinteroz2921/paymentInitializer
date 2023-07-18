package com.co.bancolombia.paymentInitializer.dto.confirm.responseConfirm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@lombok.Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class DataConfirm {
    public String trazabilityCode;
    public String transactionState;
    public String authorizationId;
    public Date bankProcessDate;
}
