package com.onlineschool.schoolmanagementsystem.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "Student_Table")
@Data
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String name;
	String standard;
	String section;
	String password;
	String feesStatus;
	//AddressEntity address;
	//String address;
	Long addressId;
	String email;
	String phone;
	Date admissionDate;
	Date schoolLeavingDay;
}
