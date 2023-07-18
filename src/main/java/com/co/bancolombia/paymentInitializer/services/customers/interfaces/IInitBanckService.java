package com.co.bancolombia.paymentInitializer.services.customers.interfaces;

import com.co.bancolombia.paymentInitializer.dto.confirm.requestConfirm.RequestConfirm;
import com.co.bancolombia.paymentInitializer.dto.customers.CustomersDTO;
import com.co.bancolombia.paymentInitializer.dto.customers.CustomersRequest;
import com.co.bancolombia.paymentInitializer.dto.initbank.RequestInit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInitBanckService {

    Boolean save(RequestInit requestInit);

    Boolean update(RequestConfirm requestConfirm);
}
