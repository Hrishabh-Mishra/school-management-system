package com.onlineschool.schoolmanagementsystem.entity;

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
	String email;
	String phone;
	String password;
}
