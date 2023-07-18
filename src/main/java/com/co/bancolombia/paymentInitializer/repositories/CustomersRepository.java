package com.co.bancolombia.paymentInitializer.repositories;


import com.co.bancolombia.paymentInitializer.entities.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepository  extends CrudRepository<Customers,Integer> {

    @Transactional(readOnly = true)
    Optional<Customers> findByCustomerAccount (String customerAccount);
    List<Customers> findALLByCustomerDocNumber(String customerDocNumber);
}
