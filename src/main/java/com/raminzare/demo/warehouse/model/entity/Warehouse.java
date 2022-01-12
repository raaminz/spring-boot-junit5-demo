package com.raminzare.demo.warehouse.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "WAREHOUSES")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {
	@Id
	@Column(name = "warehouse_id")
	private Long id;
	@JoinColumn(name = "address_id" )
	@ManyToOne(fetch = FetchType.LAZY)
	private Address address;
	@Column(name = "warehouse_name" , nullable = false)
	private String name;
	private String createdBy;
	private Date creationDate;
	private String lastUpdatedBy;
	private Date lastUpdateDate;
	private Long objectVersionId;
}
