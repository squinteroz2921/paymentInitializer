package com.co.bancolombia.paymentInitializer.dto.confirm.responseConfirm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@lombok.Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponseConfirm {
    public String responseCode;
    public String responseMessage;
    public String responseDetails;
}
