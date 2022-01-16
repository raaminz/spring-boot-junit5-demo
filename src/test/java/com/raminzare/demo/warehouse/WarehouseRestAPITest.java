package com.raminzare.demo.warehouse;


import com.raminzare.demo.warehouse.exception.WarehouseNotFoundException;
import com.raminzare.demo.warehouse.model.dto.WarehouseDTO;
import com.raminzare.demo.warehouse.model.entity.Address;
import com.raminzare.demo.warehouse.model.entity.Warehouse;
import com.raminzare.demo.warehouse.service.api.WarehouseRestAPI;
import com.raminzare.demo.warehouse.service.repo.WarehouseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class WarehouseRestAPITest {

	@Mock
	WarehouseRepository warehouseRepository;
	@InjectMocks
	WarehouseRestAPI warehouseRestAPI;

	@Test
	void getById_returnObject() throws WarehouseNotFoundException {
		Mockito.when(warehouseRepository.findById(1L)).thenReturn(Optional.of(dumpWarehouse));
		WarehouseDTO dto = warehouseRestAPI.getById(1L);
		Assertions.assertEquals(1L , dto.getId());
		Assertions.assertEquals("W1" , dto.getName());
	}

	@Test
	void getById_noObjectFound_throwsException() {
		Mockito.when(warehouseRepository.findById(1L)).thenReturn(Optional.empty());
		Assertions.assertThrows(WarehouseNotFoundException.class,
				()->  warehouseRestAPI.getById(1L));

	}

	static Warehouse dumpWarehouse;
	@BeforeAll
	static void beforeAll(){
		dumpWarehouse = new Warehouse();
		dumpWarehouse.setId(1L);
		dumpWarehouse.setName("W1");
		dumpWarehouse.setAddress(new Address());
	}
}
