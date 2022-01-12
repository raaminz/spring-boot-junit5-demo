package com.raminzare.demo.warehouse.service.api;

import com.raminzare.demo.warehouse.exception.WarehouseNotFoundException;
import com.raminzare.demo.warehouse.model.dto.WarehouseDTO;
import com.raminzare.demo.warehouse.model.entity.Warehouse;
import com.raminzare.demo.warehouse.model.mapper.ObjectMapper;
import com.raminzare.demo.warehouse.service.repo.WarehouseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("warehouse")
public class WarehouseRestAPI {

    WarehouseRepository warehouseRepository;

    public WarehouseRestAPI(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @GetMapping("/{id:\\d+}")
    public WarehouseDTO getById(@PathVariable Long id) throws WarehouseNotFoundException {
        return ObjectMapper.toDTO(warehouseRepository.findById(id).orElseThrow(WarehouseNotFoundException::new));
    }

    @ExceptionHandler(WarehouseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIError ifNoWarehouseFound(){
        return new APIError(WarehouseNotFoundException.class.getSimpleName());
    }
}
