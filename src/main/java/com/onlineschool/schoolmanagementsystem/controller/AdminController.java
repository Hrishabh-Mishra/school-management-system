package com.onlineschool.schoolmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineschool.schoolmanagementsystem.dto.StaffDTO;
import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;
import com.onlineschool.schoolmanagementsystem.service.StaffService;
import com.onlineschool.schoolmanagementsystem.service.StudentService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	//@Qualifier("studentService")
	StudentService studentService;
	
	@Autowired
	//@Qualifier("staffService")
	StaffService staffService;
	
	@PostMapping("student/register")
	public ResponseEntity<StudentDTO> register(@RequestBody StudentDTO studentDTO){
		studentDTO = studentService.register(studentDTO);
		return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
	}
	
	@PatchMapping("student/updateFeesStatus")
	public ResponseEntity<StudentDTO> updateFeesStatus(@RequestBody StudentDTO studentDTO){
		ResponseEntity<StudentDTO> response;
		if(studentDTO.getId()!=null && studentDTO.getFeesStatus()!=null) {
			studentDTO = studentService.updateFeeStatus(studentDTO);
			response = new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
		}else {
			response = new ResponseEntity<StudentDTO>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
		
	
	@PostMapping("staff/register")
	public ResponseEntity<StaffDTO> register(@RequestBody StaffDTO staffDTO){
		staffDTO = staffService.register(staffDTO);
		return new ResponseEntity<>(staffDTO, HttpStatus.CREATED);
	}

}