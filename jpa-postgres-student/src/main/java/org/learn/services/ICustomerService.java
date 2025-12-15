package org.learn.services;

import org.learn.dto.DtoCustomer;

public interface ICustomerService {

    public DtoCustomer findCustomerById(Long id);
}
