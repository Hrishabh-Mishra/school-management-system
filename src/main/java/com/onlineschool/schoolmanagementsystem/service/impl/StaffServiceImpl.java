package com.onlineschool.schoolmanagementsystem.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.onlineschool.schoolmanagementsystem.converter.StaffObjectConverter;
import com.onlineschool.schoolmanagementsystem.dto.StaffDTO;
import com.onlineschool.schoolmanagementsystem.entity.StaffEntity;
import com.onlineschool.schoolmanagementsystem.repository.StaffRepository;
import com.onlineschool.schoolmanagementsystem.repository.StudentRepository;
import com.onlineschool.schoolmanagementsystem.service.AdminCommonService;
import com.onlineschool.schoolmanagementsystem.service.AdminStaffService;

@Service
public class StaffServiceImpl implements AdminStaffService{

	@Autowired
	StaffRepository staffRepository;
	@Autowired
	StaffObjectConverter converter;
	@Override
	public StaffDTO register(StaffDTO staffDTO) {
		Optional<StaffEntity> staffEntityOp = staffRepository.findByEmail(staffDTO.getEmail());
		if(staffEntityOp.isPresent()) {
			//throw error
		}
		else {
			StaffEntity staffEntity = converter.staffDTOtoEntityConverter(staffDTO);
			staffEntity = staffRepository.save(staffEntity);
			staffDTO = converter.staffEntitytoDTOConverter(staffEntity);
			return staffDTO;
		}
		return null;
	}
	@Override
	public StaffDTO fetchDetails(Integer dtoObject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public StaffDTO updateName(StaffDTO dtoObject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public StaffDTO updateAddress(StaffDTO dtoObject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public StaffDTO updateStatus(StaffDTO dtoObject) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public StaffDTO updateSalaryStatus(StaffDTO staffDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public StaffDTO updateCTC(StaffDTO staffDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Bean
	public AdminCommonService<StaffDTO> staffService() {
	    return new StaffServiceImpl();
	}
}
