package com.onlineschool.schoolmanagementsystem.service.impl;

import com.onlineschool.schoolmanagementsystem.converter.StudentObjectConverter;
import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;
import com.onlineschool.schoolmanagementsystem.entity.StudentEntity;
import com.onlineschool.schoolmanagementsystem.repository.StudentRepository;
import com.onlineschool.schoolmanagementsystem.service.StudentService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements  StudentService{

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentObjectConverter converter;
	
	@Override
	public StudentDTO register(StudentDTO studentDTO) {
		//TODO: implement student registration function here
		//studentRepository.save(studentDTO);
		
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
	
}
