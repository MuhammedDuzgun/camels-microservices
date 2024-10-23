package com.camels.address_microservice.service.impl;

import com.camels.address_microservice.dto.SaveAddressDto;
import com.camels.address_microservice.dto.UpdateAddressDto;
import com.camels.address_microservice.entity.Address;
import com.camels.address_microservice.repository.IAddressRepository;
import com.camels.address_microservice.service.IAddressService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressService implements IAddressService {

    private final IAddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public SaveAddressDto saveAddress(SaveAddressDto saveAddressDto) {
        Address address = modelMapper.map(saveAddressDto, Address.class);
        Address savedAddress = addressRepository.save(address);
        return modelMapper.map(savedAddress, SaveAddressDto.class);
    }

    @Override
    public UpdateAddressDto updateAddress(UpdateAddressDto updateAddressDto, Long id) {
        Address address = addressRepository.findById(id).get();
        address.setStreet(updateAddressDto.getStreet());
        address.setCity(updateAddressDto.getCity());
        address.setState(updateAddressDto.getState());
        address.setPostalCode(updateAddressDto.getPostalCode());
        address.setCountry(updateAddressDto.getCountry());

        Address updatedAddress = addressRepository.save(address);
        return modelMapper.map(updatedAddress, UpdateAddressDto.class);
    }

    @Override
    public SaveAddressDto getAddress(Long id) {
        Address address = addressRepository.findById(id).get();
        return modelMapper.map(address, SaveAddressDto.class);
    }
}
