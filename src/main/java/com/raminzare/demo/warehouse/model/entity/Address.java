package com.raminzare.demo.warehouse.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESSES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	@Column(name ="address_id")
	private Long id;
	@Column(nullable = false)
	private String address1;
	private String address2;
	@Column(nullable = false)
	private String city;
	private String postalCode;
	private String stateProvince;
	@Column(nullable = false)
	private String countryId;
	private Integer longitude;
	private Integer latitude;
	private String createdBy;
	private Date creationDate;
	private String lastUpdatedBy;
	private Date lastUpdateDate;
	private Long objectVersionId;
}