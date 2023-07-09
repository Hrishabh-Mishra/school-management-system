package com.onlineschool.schoolmanagementsystem.converter;

import org.springframework.context.annotation.Configuration;

import com.onlineschool.schoolmanagementsystem.dto.StaffDTO;
import com.onlineschool.schoolmanagementsystem.entity.StaffEntity;

@Configuration
public class StaffObjectConverter {
	public StaffEntity staffDTOtoEntityConverter(StaffDTO sdto) {
		StaffEntity se = new StaffEntity();
		se.setName(sdto.getName());
		se.setEmail(sdto.getEmail());
		se.setPhone(sdto.getPhone());
		se.setPassword(sdto.getPassword());
		return se;
	}
	
	public StaffDTO staffEntitytoDTOConverter(StaffEntity se) {
		StaffDTO sdto = new StaffDTO();
		sdto.setId(se.getId());
		sdto.setName(se.getName());
		sdto.setEmail(se.getEmail());
		sdto.setPhone(se.getPhone());
		return sdto;
	}
}
