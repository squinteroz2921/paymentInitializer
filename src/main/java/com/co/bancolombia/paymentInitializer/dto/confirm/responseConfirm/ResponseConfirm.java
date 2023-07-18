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
public class ResponseConfirm {
    public HeadersConfirm headers;
    public MessageResponseConfirm messageResponse;
    public DataConfirm data;
}
