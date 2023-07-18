package com.co.bancolombia.paymentInitializer.utils.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseInfo {
    @JsonProperty("message")
    private Object message;
    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("httpStatus")
    private HttpStatus httpStatus;
    @JsonProperty("uri")
    private String uriRequested;
    @JsonProperty("timestamp")
    private String timestamp;

    public ResponseInfo(Object message, int statusCode, HttpStatus httpStatus,
                        String uriRequested, String timestamp){
        this.message = message;
        this.statusCode = statusCode;
        this.httpStatus = httpStatus;
        this.uriRequested = uriRequested;
        this.timestamp = timestamp;
    }
}
