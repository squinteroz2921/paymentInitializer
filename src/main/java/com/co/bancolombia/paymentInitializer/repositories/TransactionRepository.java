package com.co.bancolombia.paymentInitializer.repositories;

import com.co.bancolombia.paymentInitializer.entities.transacction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<transacction, String> {

    transacction findBytrazabilityCode(String id);



}
