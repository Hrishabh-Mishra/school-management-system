package com.onlineschool.schoolmanagementsystem.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class StudentDTO {
	Integer id;	
	String name;
	String standard;
	String section;
	String password;
	String feesStatus;
	AddressDTO address;
	//String address;
	String email;
	String phone;
	ParentDTO parent1;
	ParentDTO parent2;
	Date admissionDate;
	Date schoolLeavingDay;
	
}
