package org.learn.services;

import org.learn.dto.DtoAddress;

public interface IAddressService {
    public DtoAddress getAddressById(Long id);

}
