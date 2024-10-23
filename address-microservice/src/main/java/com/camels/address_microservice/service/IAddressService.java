package com.camels.address_microservice.service;

import com.camels.address_microservice.dto.SaveAddressDto;
import com.camels.address_microservice.dto.UpdateAddressDto;

public interface IAddressService {
    SaveAddressDto saveAddress(SaveAddressDto saveAddressDto);
    UpdateAddressDto updateAddress(UpdateAddressDto updateAddressDto, Long id);
    SaveAddressDto getAddress(Long id);
}
