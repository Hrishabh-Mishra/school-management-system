package com.onlineschool.schoolmanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AddressDTO {
	Integer addressId;
	Integer pincode;
	String houseNo;//Flat Number
	String locality;
	String street;
	String district;
	String state;
	String landmark;
	String postOffice;
	
	
}
