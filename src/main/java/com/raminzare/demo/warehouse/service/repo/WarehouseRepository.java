package com.raminzare.demo.warehouse.service.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.raminzare.demo.warehouse.model.entity.Warehouse;


@Repository
public interface WarehouseRepository
		extends PagingAndSortingRepository<Warehouse, Long>, QueryByExampleExecutor<Warehouse> {

}
