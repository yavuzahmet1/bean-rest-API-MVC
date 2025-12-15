package org.learn.controller;

import org.learn.dto.DtoAddress;

public interface IAddressController {

    public DtoAddress addressGetById(Long id);
    
}
