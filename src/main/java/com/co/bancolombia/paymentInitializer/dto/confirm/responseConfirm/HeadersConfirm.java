package com.co.bancolombia.paymentInitializer.dto.confirm.responseConfirm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@lombok.Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class HeadersConfirm {
    public int httpStatusCode;
    public String htttpStatusDesc;
    public Date timestamp;
}
