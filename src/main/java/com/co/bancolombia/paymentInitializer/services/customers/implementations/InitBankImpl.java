package com.co.bancolombia.paymentInitializer.services.customers.implementations;

import com.co.bancolombia.paymentInitializer.dto.confirm.requestConfirm.RequestConfirm;
import com.co.bancolombia.paymentInitializer.dto.customers.CustomersDTO;
import com.co.bancolombia.paymentInitializer.dto.initbank.RequestInit;
import com.co.bancolombia.paymentInitializer.entities.Customers;
import com.co.bancolombia.paymentInitializer.entities.transacction;
import com.co.bancolombia.paymentInitializer.repositories.CustomersRepository;
import com.co.bancolombia.paymentInitializer.repositories.TransactionRepository;
import com.co.bancolombia.paymentInitializer.services.customers.interfaces.IInitBanckService;
import com.co.bancolombia.paymentInitializer.utils.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class InitBankImpl implements IInitBanckService {


    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Boolean save(RequestInit requestInit) {


        var  transaction = Mapper.modelMapper().map(requestInit, transacction.class);
        var id = UUID.randomUUID();
        transaction.setId(String.valueOf(id));
        transaction.setCreated_on(Date.valueOf(LocalDate.now()));
        transaction.setUpdate_on(Date.valueOf(LocalDate.now()));
        var transactionSave = this.transactionRepository.save(transaction);
        var transactionDTO= Mapper.modelMapper().map(transactionSave, RequestInit.class);
        return true;
    }

    @Override
    public Boolean update(RequestConfirm requestConfirm) {


        var findTransaction = transactionRepository.findBytrazabilityCode(requestConfirm.getTrazabilityCode());

        findTransaction.setTransactionState("OK");
        transactionRepository.save(findTransaction);
        return true;
    }
}
