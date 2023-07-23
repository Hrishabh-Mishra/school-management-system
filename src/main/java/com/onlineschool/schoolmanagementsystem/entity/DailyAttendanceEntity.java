package com.onlineschool.schoolmanagementsystem.entity;

import java.sql.Timestamp;
import java.util.Date;

import com.onlineschool.schoolmanagementsystem.enums.AttendanceStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
//@IdClass(AttendanceCompositeKey.class)
@Table(name = "Daily_Attendance_Table")
@Data
public class DailyAttendanceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date date;
//	@Id
//	private Timestamp timestamp;
	private String standard;
	private String section;
	private Integer teacherId;
	private Integer studentId;
	private Character attendanceStatus;//A - Absent; P - Present; L - Leave
}