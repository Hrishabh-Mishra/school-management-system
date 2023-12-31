package com.onlineschool.schoolmanagementsystem.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class StaffDTO {
	long id;
	String name;
	String email;
	String phone;
	String password;
	String address;
	String salaryStatus;
	String salaryAmount;
	String staffType;
	String classTeacher;
	Date joiningDate;
}
