package com.onlineschool.schoolmanagementsystem.converter;

import org.springframework.context.annotation.Configuration;

import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;
import com.onlineschool.schoolmanagementsystem.entity.StudentEntity;

@Configuration
public class StudentObjectConverter {

	AddressConverter addressConverter;
	
	public StudentEntity studentDTOtoEntityConverter(StudentDTO sdto) {
		StudentEntity se = new StudentEntity();
		se.setName(sdto.getName());
		se.setEmail(sdto.getEmail());
		se.setPhone(sdto.getPhone());
		se.setPassword(sdto.getPassword());
		se.setAddress(addressConverter.addressDTOToEntityConverter(sdto.getAddress()));
		se.setFeesStatus(sdto.getFeesStatus());
		se.setSchoolLeavingDay(sdto.getSchoolLeavingDay());
		se.setSection(sdto.getSection());
		se.setStandard(sdto.getStandard());
		se.setAdmissionDate(sdto.getAdmissionDate());
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
