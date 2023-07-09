package com.onlineschool.schoolmanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Address_Table")
@Data
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long addressId;
	Integer pincode;
	String houseNo;//Flat Number
	String locality;
	String street;
	String district;
	String state;
	String landmark;
	String postOffice;
	
}
