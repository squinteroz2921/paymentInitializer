package com.co.bancolombia.paymentInitializer.repositories;

import com.co.bancolombia.paymentInitializer.entities.transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<transaction, String> {


}
