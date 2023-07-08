package com.onlineschool.schoolmanagementsystem.converter;

import org.springframework.context.annotation.Configuration;

import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;
import com.onlineschool.schoolmanagementsystem.entity.StudentEntity;

@Configuration
public class StudentObjectConverter {

	public StudentEntity studentDTOtoEntityConverter(StudentDTO sdto) {
		StudentEntity se = new StudentEntity();
		se.setName(sdto.getName());
		se.setEmail(sdto.getEmail());
		se.setPhone(sdto.getPhone());
		se.setPassword(sdto.getPassword());
		return se;
	}
	
	public StudentDTO studentEntitytoDTOConverter(StudentEntity se) {
		StudentDTO sdto = new StudentDTO();
		sdto.setId(se.getId());
		sdto.setName(se.getName());
		sdto.setEmail(se.getEmail());
		sdto.setPhone(se.getPhone());
		return sdto;
	}
}
