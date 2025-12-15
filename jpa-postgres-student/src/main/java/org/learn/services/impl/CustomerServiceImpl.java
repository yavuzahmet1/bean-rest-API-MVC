package org.learn.services.impl;

import org.learn.dto.DtoAddress;
import org.learn.dto.DtoCustomer;
import org.learn.entities.Address;
import org.learn.entities.Customer;
import org.learn.repository.CustomerRepository;
import org.learn.services.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements ICustomerService{
    private final CustomerRepository customerRepository;
    

    @Override
    @Transactional(readOnly = true)
    public DtoCustomer findCustomerById(Long id) {
        log.info("Customer is being fetched with ID:{}",id);

        Customer customer = customerRepository.findById(id).orElseThrow(()->{
            log.warn("Customer not found with ID: {}",id);
            return new RuntimeException("Customer not found with ID: " + id);});

        return mapToDtoCustomer(customer);
    }
    private DtoCustomer mapToDtoCustomer(Customer customer) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setId(customer.getId());
        dtoCustomer.setName(customer.getName());

        Address address = customer.getAddress();
        if (address != null) {
            DtoAddress dtoAddress = new DtoAddress();
            dtoAddress.setId(address.getId());
            dtoAddress.setDescription(address.getDescription());
            dtoCustomer.setAddress(dtoAddress);
        }
        return dtoCustomer;
    
    }
}
