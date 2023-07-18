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
public class Root{
    public Headers headers;
    public MessageResponse messageResponse;
    public Data data;
}
