package com.camels.address_microservice.controller;

import com.camels.address_microservice.dto.SaveAddressDto;
import com.camels.address_microservice.dto.UpdateAddressDto;
import com.camels.address_microservice.service.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final IAddressService addressService;

    @PostMapping("/save-address")
    public ResponseEntity<SaveAddressDto> saveAddress(@RequestBody SaveAddressDto saveAddressDto) {
        SaveAddressDto saveAddress = addressService.saveAddress(saveAddressDto);
        return ResponseEntity.ok().body(saveAddress);
    }

    @PostMapping("/update-address/{id}")
    public ResponseEntity<UpdateAddressDto> updateAddress(@RequestBody UpdateAddressDto updateAddressDto,
                                                          @PathVariable(name = "id") Long id) {
        UpdateAddressDto updatedAddressDto = addressService.updateAddress(updateAddressDto, id);
        return ResponseEntity.ok().body(updatedAddressDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaveAddressDto> getAddress(@PathVariable(name = "id") Long id) {
        SaveAddressDto saveAddressDto = addressService.getAddress(id);
        return ResponseEntity.ok().body(saveAddressDto);
    }

}
