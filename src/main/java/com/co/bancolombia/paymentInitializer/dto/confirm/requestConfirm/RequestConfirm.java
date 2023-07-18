package com.co.bancolombia.paymentInitializer.dto.confirm.requestConfirm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@lombok.Data
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RequestConfirm {
    public String trazabilityCode;
    public String accountId;
    public String deviceFingerPrint;
    public String fraudResponseCode;
    public String fraudPreAuthorizationScore;
    public String transactionState;
}
