package com.co.bancolombia.paymentInitializer.repositories;

import com.co.bancolombia.paymentInitializer.entities.transacction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<transacction, Integer> {


}
