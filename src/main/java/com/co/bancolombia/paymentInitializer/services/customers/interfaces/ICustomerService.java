package com.co.bancolombia.paymentInitializer.services.customers.interfaces;

import com.co.bancolombia.paymentInitializer.dto.customers.CustomersDTO;
import com.co.bancolombia.paymentInitializer.dto.customers.CustomersRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerService {

    CustomersDTO save(CustomersRequest customersRequest);
    CustomersDTO update(CustomersRequest customersRequest);
    List<CustomersDTO>  findCustomer (String documentNumber );
}
