package com.onlineschool.schoolmanagementsystem.dto;

import java.util.Date;

import lombok.Getter;
@Getter
public class StudentAttendanceDTO {
	private Integer studentId;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "E, dd MMM yyyy HH:mm:ss z", timezone = "GMT+2")
	//private Timestamp timestamp;
	private Date timestamp;
	private Character attendanceStatus; //P,A,L
}
