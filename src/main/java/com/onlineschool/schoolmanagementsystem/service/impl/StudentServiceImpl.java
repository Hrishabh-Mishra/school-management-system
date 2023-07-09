package com.onlineschool.schoolmanagementsystem.service.impl;

import com.onlineschool.schoolmanagementsystem.converter.StudentObjectConverter;
import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;
import com.onlineschool.schoolmanagementsystem.entity.StudentEntity;
import com.onlineschool.schoolmanagementsystem.repository.StudentRepository;
import com.onlineschool.schoolmanagementsystem.service.AdminService;
import com.onlineschool.schoolmanagementsystem.service.StudentService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements  StudentService{

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentObjectConverter converter;
	
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
			StudentEntity studentEntity = converter.studentDTOtoEntityConverter(studentDTO);
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
			studentEntity = studentRepository.save(studentEntity);
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
	public StudentDTO fetchDetails(long dtoObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Bean
	public AdminService<StudentDTO> studentService() {
	    return new StudentServiceImpl();
	}
	
}
