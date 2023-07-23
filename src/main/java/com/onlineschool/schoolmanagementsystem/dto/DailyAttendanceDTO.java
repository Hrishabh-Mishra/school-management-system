package com.onlineschool.schoolmanagementsystem.dto;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;
@Data
public class DailyAttendanceDTO {
	private String standard;
	private String section;
	private Integer teacherId;
	//private Date date;
	private ArrayList<StudentAttendanceDTO> studentsAttendance;
}
