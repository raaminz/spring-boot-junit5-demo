package com.raminzare.demo.warehouse.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private Long id;
    private String address1;
    private String address2;
    private String city;
    private String postalCode;
    private String stateProvince;
    private String countryId;
}