package com.raminzare.demo.warehouse.model.dto;

import com.raminzare.demo.warehouse.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseDTO {
    private Long id;
    private AddressDTO address;
    private String name;
}
