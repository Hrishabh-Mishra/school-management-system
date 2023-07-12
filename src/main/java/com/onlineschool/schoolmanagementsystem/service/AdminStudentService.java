package com.onlineschool.schoolmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;

@Service
public interface AdminStudentService extends AdminCommonService<StudentDTO>{
	
	public StudentDTO fetchMarksDetails(Integer studentID);//get
	public StudentDTO updateFeeStatus(StudentDTO studentDTO);//patch
	public StudentDTO updateDetails(StudentDTO studentDTO);//patch
	public List<StudentDTO> fetchAllStudentDetails();
	
	//TODO make an abstract class - with common functions in implementation layer.
	
}
