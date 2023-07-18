package com.co.bancolombia.paymentInitializer.repositories;

import com.co.bancolombia.paymentInitializer.entities.account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<account, Integer> {


}
