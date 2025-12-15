package org.learn.controller.impl;

import org.learn.controller.ICustomerController;
import org.learn.dto.DtoCustomer;
import org.learn.services.ICustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/customers")
public class CustomerControllerImpl implements ICustomerController{

    private ICustomerService customerService;

    public CustomerControllerImpl(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/all/{id}")
    @Override
    public DtoCustomer getCustomerById(@PathVariable Long id) {

        return customerService.findCustomerById(id);
    }
    


}
