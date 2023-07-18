package com.co.bancolombia.paymentInitializer.services.customers.implementations;

import com.co.bancolombia.paymentInitializer.dto.customers.CustomersDTO;
import com.co.bancolombia.paymentInitializer.dto.customers.CustomersRequest;
import com.co.bancolombia.paymentInitializer.entities.Customers;
import com.co.bancolombia.paymentInitializer.repositories.CustomersRepository;
import com.co.bancolombia.paymentInitializer.services.customers.interfaces.ICustomerService;
import com.co.bancolombia.paymentInitializer.utils.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Component
public class CustomersImpl implements ICustomerService {

    private Logger logger = LoggerFactory.getLogger(CustomersImpl.class);
    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public CustomersDTO save(CustomersRequest customersRequest) {
        logger.info("se inicia proceso de inscripcion del usuario: "+customersRequest.getCustomerDocNumber());
        Customers customers = Mapper.modelMapper().map(customersRequest, Customers.class);
        Customers customerSave = this.customersRepository.save(customers);
        CustomersDTO customersDTO= Mapper.modelMapper().map(customerSave, CustomersDTO.class);
        logger.info("Inscripcion de usuario Exitosa con doc:" + customersDTO.getCustomerDocNumber());
        return customersDTO;
    }

    @Override
    public CustomersDTO update(CustomersRequest customersRequest) {
        return null;
    }

    @Override
    public List<CustomersDTO> findCustomer(String documentNumber) {
        logger.info("se inicia proceso de busqueda del usuario: "+documentNumber);
        List<CustomersDTO> customersDTOs = new ArrayList<>();
        try{
            List<Customers> customers =  this.customersRepository.findALLByCustomerDocNumber(documentNumber);
            System.out.println("customers = " + customers);
            for (Customers customer: customers){
                customersDTOs.add(Mapper.modelMapper().map(customer, CustomersDTO.class));
            }
//            customersDTOs =  Mapper.modelMapper().map(customers.get(), CustomersDTO.class);
            logger.info("se finaliza proceso de busqueda del usuario: "+ documentNumber);
            return customersDTOs;
        }
        catch (Exception e){
            CustomersDTO customersDTO = new CustomersDTO();
            System.out.println(e);
            logger.info("no fue posible realizar la busqueda del usuario: "+ documentNumber);
            return customersDTOs;
        }
    }
}
