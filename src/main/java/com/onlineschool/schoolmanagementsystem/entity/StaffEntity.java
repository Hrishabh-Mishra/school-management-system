package com.onlineschool.schoolmanagementsystem.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Staff_Table")
@Data
public class StaffEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
