package com.onlineschool.schoolmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineschool.schoolmanagementsystem.dto.DailyAttendanceDTO;
import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;
import com.onlineschool.schoolmanagementsystem.service.TeacherService;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	@PostMapping("markAttendance")
	public ResponseEntity markAttendance(@RequestBody DailyAttendanceDTO attendanceDTO) {
		ResponseEntity response;
		if(teacherService.markAttendance(attendanceDTO))
			response = new ResponseEntity(HttpStatus.ACCEPTED);
		response  = new ResponseEntity(HttpStatus.PAYLOAD_TOO_LARGE);
		return response;
	}
}
