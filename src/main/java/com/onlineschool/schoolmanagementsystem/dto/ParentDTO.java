package com.onlineschool.schoolmanagementsystem.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.onlineschool.schoolmanagementsystem.entity.AddressEntity;

import jakarta.persistence.Id;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ParentDTO {
	Integer parentId;
	String name;
	String password;
	String relation; //TODO make it enum - Father/Mother/Guardian
	String email;
	String phone;
	String profession;
	AddressDTO address;
}
