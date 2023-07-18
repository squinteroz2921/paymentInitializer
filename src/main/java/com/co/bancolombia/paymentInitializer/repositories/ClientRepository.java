package com.co.bancolombia.paymentInitializer.repositories;

import com.co.bancolombia.paymentInitializer.entities.client;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClientRepository extends CrudRepository<client, Integer> {


}
