package org.learn.services.impl;

import org.learn.dto.DtoAddress;
import org.learn.entities.Address;
import org.learn.repository.AddressRepository;
import org.learn.services.IAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AddressServiceImpl implements IAddressService{
    private final AddressRepository addressRepository;

    @Override
    @Transactional(readOnly = true)
    public DtoAddress getAddressById(Long id) {
        log.info("Address is being fetched with ID:{}",id);
        Address address = addressRepository.findById(id)
            .orElseThrow(()->{
                log.warn("Address not found with ID: {}",id);
                return new RuntimeException("Address not found with ID: " + id);});
        return mapToDto(address);
    }

    private DtoAddress mapToDto(Address address) {
        DtoAddress dtoAddress = new DtoAddress();
        dtoAddress.setId(address.getId());
        dtoAddress.setDescription(address.getDescription());
        return dtoAddress;
    }

}

