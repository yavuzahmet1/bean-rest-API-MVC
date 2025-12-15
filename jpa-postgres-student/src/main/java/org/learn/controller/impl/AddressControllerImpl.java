package org.learn.controller.impl;

import org.learn.controller.IAddressController;
import org.learn.dto.DtoAddress;
import org.learn.services.IAddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressControllerImpl implements IAddressController{   

    private final IAddressService addressService;
   
    @GetMapping(path = "/all/{id}")
    @Override
    public DtoAddress addressGetById(@RequestParam Long id) {
        return addressService.getAddressById(id);
    }
    


}
