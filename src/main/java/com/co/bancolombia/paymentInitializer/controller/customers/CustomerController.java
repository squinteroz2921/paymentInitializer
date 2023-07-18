package com.co.bancolombia.paymentInitializer.controller.customers;

import com.co.bancolombia.paymentInitializer.dto.confirm.requestConfirm.RequestConfirm;
import com.co.bancolombia.paymentInitializer.dto.confirm.responseConfirm.DataConfirm;
import com.co.bancolombia.paymentInitializer.dto.confirm.responseConfirm.HeadersConfirm;
import com.co.bancolombia.paymentInitializer.dto.confirm.responseConfirm.MessageResponseConfirm;
import com.co.bancolombia.paymentInitializer.dto.confirm.responseConfirm.ResponseConfirm;
import com.co.bancolombia.paymentInitializer.dto.customers.CustomersDTO;
import com.co.bancolombia.paymentInitializer.dto.customers.CustomersRequest;
import com.co.bancolombia.paymentInitializer.dto.initbank.*;
import com.co.bancolombia.paymentInitializer.services.customers.interfaces.ICustomerService;
import com.co.bancolombia.paymentInitializer.services.customers.interfaces.IInitBanckService;
import com.co.bancolombia.paymentInitializer.utils.response.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/payment-initializer/api/customer")
public class CustomerController {
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private String URI ="/payment-initializer/api/customer";

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IInitBanckService iInitBanckService;



    @PostMapping("/open-banking/v1/psp/confirm-transaction")
    public ResponseEntity<ResponseConfirm> confirm(@RequestBody RequestConfirm requestConfirm){

        iInitBanckService.update(requestConfirm);


        var root = new ResponseConfirm();


        var data = new DataConfirm();
        data.setAuthorizationId("70274856");
        data.setTransactionState("OK");
        data.setTrazabilityCode(requestConfirm.getTrazabilityCode());
        data.setBankProcessDate(Date.valueOf(LocalDate.now()));
        root.setData(data);
        var headers = new HeadersConfirm();
        headers.setHttpStatusCode(200);
        headers.setHtttpStatusDesc("OK");
        headers.setTimestamp(Date.valueOf(LocalDate.now()));
        root.setHeaders(headers);

        var messageResponse = new MessageResponseConfirm();

        messageResponse.setResponseCode("0000");
        messageResponse.setResponseMessage("Transacción exitosa.");
        messageResponse.setResponseDetails("System process information.");
        root.setMessageResponse(messageResponse);
        return ResponseEntity.ok().body(root);


    }

    @PostMapping("open-banking/v1/psp/initbank-paymentof")
    public ResponseEntity<Root> InitBank(@RequestBody RequestInit requestInit){

            iInitBanckService.save(requestInit);


            var root = new Root();


            var data = new Data();
            data.setBankUrl("https://bancoalfa.ext.v1.openfinance.achcolombia.com.co/oauth2/authorize?response_type=code&scope=accounts.list%20transaction.pay%20openid&client_id=ach-open-finance");
            data.setReturnCode("SUCCESS");
            data.setTransactionValue(requestInit.getTransactionValue());
            data.setTrazabilityCode(requestInit.getTrazabilityCode());
            root.setData(data);
            var headers = new Headers();
            headers.setHttpStatusCode(200);
            headers.setHtttpStatusDesc("OK");
            headers.setTimestamp(Date.valueOf(LocalDate.now()));
            root.setHeaders(headers);

            var messageResponse = new MessageResponse();

            messageResponse.setResponseCode("0000");
            messageResponse.setResponseMessage("Transacción exitosa.");
            messageResponse.setResponseDetails("System process information.");
            root.setMessageResponse(messageResponse);
            return ResponseEntity.ok().body(root);


    }

    @GetMapping("pruena")
    public String InitBank2(){
return "hola";
    }

    @GetMapping(path = "/{documentNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseInfo> getCustomer(@PathVariable("documentNumber") String documentNumber){

        logger.info("consultando customer"+ documentNumber);
        try{
            List<CustomersDTO> customersDTOS = this.iCustomerService.findCustomer(documentNumber);
            if (!customersDTOS.isEmpty()){
                ResponseInfo responseInfo = new ResponseInfo(
                        customersDTOS,
                        HttpStatus.OK.value(),
                        HttpStatus.OK,
                        URI,
                        LocalDateTime.now().format(formatter)

                );
                return new ResponseEntity<>(responseInfo,HttpStatus.OK);
            }
            else{
                ResponseInfo responseInfo = new ResponseInfo(
                        "No existe informacion del cliente",
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        HttpStatus.NO_CONTENT,
                        URI,
                        LocalDateTime.now().format(formatter)
                );
                return new ResponseEntity<>(responseInfo,HttpStatus.INTERNAL_SERVER_ERROR);

            }


        }
        catch (Exception e){
            ResponseInfo responseInfo = new ResponseInfo(
                    "No existe informacion del cliente",
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.NO_CONTENT,
                    URI,
                    LocalDateTime.now().format(formatter)
            );
            return new ResponseEntity<>(responseInfo,HttpStatus.INTERNAL_SERVER_ERROR);

        }
}
    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseInfo> saveCustomer(@RequestBody CustomersRequest customersRequest){
        try{
            CustomersDTO customersDTO =  this.iCustomerService.save(customersRequest);
            ResponseInfo responseInfo = new ResponseInfo(
                    customersDTO,
                    HttpStatus.OK.value(),
                    HttpStatus.OK,
                    URI,
                    LocalDateTime.now().format(formatter)
            );
            return new ResponseEntity<>(responseInfo,HttpStatus.OK);
        }
        catch (Exception e){

            ResponseInfo responseInfo = new ResponseInfo(
                    "no fue posible inscribir al usuario",
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    URI,
                    LocalDateTime.now().format(formatter)
            );
            return new ResponseEntity<>(responseInfo,HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}





