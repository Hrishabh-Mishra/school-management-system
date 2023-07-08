package com.onlineschool.schoolmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;
import com.onlineschool.schoolmanagementsystem.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<StudentDTO> register(@RequestBody StudentDTO studentDTO){
		studentDTO = studentService.register(studentDTO);
		return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
	}
}