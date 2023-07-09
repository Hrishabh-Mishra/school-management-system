package com.onlineschool.schoolmanagementsystem.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;

@Service
//@Qualifier
public interface StudentService extends AdminService<StudentDTO>{
	
	public StudentDTO fetchMarksDetails(long studentID);//get
	public StudentDTO updateFeeStatus(StudentDTO studentDTO);//patch
	
	//TODO make an abstract class - with common functions in implementation layer.
	
}
