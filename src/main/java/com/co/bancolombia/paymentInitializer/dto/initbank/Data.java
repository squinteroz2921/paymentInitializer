package com.co.bancolombia.paymentInitializer.dto.initbank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@lombok.Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Data{
    public String trazabilityCode;
    public int transactionValue;
    public String returnCode;
    public String bankUrl;
}
