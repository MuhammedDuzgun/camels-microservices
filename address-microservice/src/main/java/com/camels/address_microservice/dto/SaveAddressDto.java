package com.camels.address_microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveAddressDto {
    private Long userId;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}
