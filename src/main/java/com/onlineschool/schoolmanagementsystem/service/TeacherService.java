package com.onlineschool.schoolmanagementsystem.service;

import org.springframework.stereotype.Service;

import com.onlineschool.schoolmanagementsystem.dto.DailyAttendanceDTO;
@Service
public interface TeacherService {
	public boolean markAttendance(DailyAttendanceDTO dailyAttendance);
}
