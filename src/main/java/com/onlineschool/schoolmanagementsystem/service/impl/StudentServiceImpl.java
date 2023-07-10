package com.onlineschool.schoolmanagementsystem.service.impl;

import com.onlineschool.schoolmanagementsystem.converter.AddressConverter;
import com.onlineschool.schoolmanagementsystem.converter.StudentObjectConverter;
import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;
import com.onlineschool.schoolmanagementsystem.entity.AddressEntity;
import com.onlineschool.schoolmanagementsystem.entity.StudentEntity;
import com.onlineschool.schoolmanagementsystem.repository.AddressRepositry;
import com.onlineschool.schoolmanagementsystem.repository.StudentRepository;
import com.onlineschool.schoolmanagementsystem.service.AdminCommonService;
import com.onlineschool.schoolmanagementsystem.service.AdminStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.Random;
@Service
public class StudentServiceImpl implements  AdminStudentService{

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentObjectConverter converter;
	@Autowired
	AddressConverter addressConverter;
	
	@Autowired
	AddressRepositry addressRepositry;
	@Override
	public StudentDTO fetchMarksDetails(long dtoObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO updateFeeStatus(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		Optional<StudentEntity> studentEntityOp = studentRepository.findById(studentDTO.getId());
		if(studentEntityOp.isPresent()) {
			StudentEntity studentEntity = studentEntityOp.get();
			studentEntity.setFeesStatus(studentDTO.getFeesStatus());
			studentRepository.save(studentEntity);
		}
		return studentDTO;
	}

	@Override
	public StudentDTO register(StudentDTO studentDTO) {
		Optional<StudentEntity> studentEntityOp = studentRepository.findByEmail(studentDTO.getEmail());
		if(studentEntityOp.isPresent()) {
			//throw error
		}
		else {
			StudentEntity studentEntity = converter.studentDTOtoEntityConverter(studentDTO);
			Random random = new Random();
			long randomAddressId = random.nextLong();
			studentEntity.setAddressId(randomAddressId);
			studentEntity = studentRepository.save(studentEntity);
			AddressEntity addressEntity = addressConverter.addressDTOToEntityConverter(studentDTO.getAddress());
			addressEntity.setAddressId(randomAddressId);
			addressEntity = addressRepositry.save(addressEntity);
			studentDTO = converter.studentEntitytoDTOConverter(studentEntity);
			return studentDTO;
		}
		return null;
	}

	@Override
	public StudentDTO updateName(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO updateAddress(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO updateStatus(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO fetchDetails(Long studentId) {
		Optional<StudentEntity> studentEntityOp = studentRepository.findById(studentId);
		StudentDTO studentDTO = null;
		if(studentEntityOp.isPresent()) {
			studentDTO = converter.studentEntitytoDTOConverter(studentEntityOp.get());
		}
		return studentDTO;
	}
	@Override
	public List<StudentDTO> fetchAllStudentDetails() {
		List<StudentEntity> studentEntityList = (List<StudentEntity>) studentRepository.findAll();
		List<StudentDTO> studentDTOList = new ArrayList<>();
		for (StudentEntity studentEntity : studentEntityList) {
			studentDTOList.add(converter.studentEntitytoDTOConverter(studentEntity));
		}
		return studentDTOList;
	}
}
