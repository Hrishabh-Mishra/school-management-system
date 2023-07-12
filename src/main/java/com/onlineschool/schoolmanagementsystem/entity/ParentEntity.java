package com.onlineschool.schoolmanagementsystem.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Parent_Table")
@Data
public class ParentEntity {
	@Id
	Integer parentId;
	String password;
	String name;
	String relation; //TODO make it enum - Father/Mother/Guardian
	String email;
	String phone;
	String profession;
	Integer addressId;
}
