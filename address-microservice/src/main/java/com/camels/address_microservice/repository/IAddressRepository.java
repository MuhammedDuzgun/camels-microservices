package com.camels.address_microservice.repository;

import com.camels.address_microservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
