package com.onlineschool.schoolmanagementsystem.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class StudentDTO {
	Long id;	
	String name;
	String standard;
	String section;
	String password;
	String feesStatus;
	AddressDTO address;
	//String address;
	String email;
	String phone;
	Date admissionDate;
	Date schoolLeavingDay;
}
