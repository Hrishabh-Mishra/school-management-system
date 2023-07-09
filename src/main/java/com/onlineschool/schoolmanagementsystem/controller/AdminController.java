package com.onlineschool.schoolmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineschool.schoolmanagementsystem.dto.StaffDTO;
import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;
import com.onlineschool.schoolmanagementsystem.service.AdminStaffService;
import com.onlineschool.schoolmanagementsystem.service.AdminStudentService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	//@Qualifier("studentService")
	AdminStudentService studentService;
	
	@Autowired
	//@Qualifier("staffService")
	AdminStaffService staffService;
	
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
		
	@GetMapping("student/fetchAllStudentDetails")
	public ResponseEntity<List<StudentDTO>> fetchAllStudentDetails(){
		return new ResponseEntity<>(studentService.fetchAllStudentDetails(), HttpStatus.OK);
	}
	
	@PostMapping("staff/register")
	public ResponseEntity<StaffDTO> register(@RequestBody StaffDTO staffDTO){
		staffDTO = staffService.register(staffDTO);
		return new ResponseEntity<>(staffDTO, HttpStatus.CREATED);
	}

}