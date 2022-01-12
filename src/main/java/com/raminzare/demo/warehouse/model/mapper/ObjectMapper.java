package com.raminzare.demo.warehouse.model.mapper;

import com.raminzare.demo.warehouse.model.dto.AddressDTO;
import com.raminzare.demo.warehouse.model.dto.WarehouseDTO;
import com.raminzare.demo.warehouse.model.entity.Address;
import com.raminzare.demo.warehouse.model.entity.Warehouse;

import java.util.Objects;

public final class ObjectMapper {

    private ObjectMapper(){
    }

    public static WarehouseDTO toDTO(Warehouse warehouse) {
        Objects.requireNonNull(warehouse);
        return WarehouseDTO.builder().id(warehouse.getId())
                .name(warehouse.getName())
                .address(toDTO(warehouse.getAddress())).build();
    }

    public static AddressDTO toDTO(Address address) {
        Objects.requireNonNull(address);
        return AddressDTO.builder().address1(address.getAddress1())
                .address2(address.getAddress2())
                .city(address.getCity())
                .id(address.getId())
                .postalCode(address.getPostalCode())
                .stateProvince(address.getStateProvince())
                .countryId(address.getCountryId()).build();
    }
}
