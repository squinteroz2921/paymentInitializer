package com.co.bancolombia.paymentInitializer.controller.customers;

import com.co.bancolombia.paymentInitializer.dto.customers.CustomersDTO;
import com.co.bancolombia.paymentInitializer.dto.customers.CustomersRequest;
import com.co.bancolombia.paymentInitializer.entities.Customers;
import com.co.bancolombia.paymentInitializer.services.customers.interfaces.ICustomerService;
import com.co.bancolombia.paymentInitializer.utils.response.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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





