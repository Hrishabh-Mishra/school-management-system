package com.onlineschool.schoolmanagementsystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineschool.schoolmanagementsystem.dto.DailyAttendanceDTO;
import com.onlineschool.schoolmanagementsystem.entity.DailyAttendanceEntity;
import com.onlineschool.schoolmanagementsystem.repository.AttendanceRepository;
import com.onlineschool.schoolmanagementsystem.service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	AttendanceRepository attendanceRepository;
	@Override
	public boolean markAttendance(DailyAttendanceDTO dailyAttendance) {
		boolean rvalue = false;
		String standard = dailyAttendance.getStandard();
		String section = dailyAttendance.getSection();
		Integer teacherId = dailyAttendance.getTeacherId();
		//Date date = dailyAttendance.getDate();
		List<DailyAttendanceEntity> dailyAttendanceEntityList = new ArrayList<>();
		dailyAttendance.getStudentsAttendance().forEach(studentAttendanceDTO -> {
			DailyAttendanceEntity dailyAttendanceEntity = new DailyAttendanceEntity();
			//dailyAttendanceEntity.setDate(date);
			dailyAttendanceEntity.setSection(section);
			dailyAttendanceEntity.setStandard(standard);
			dailyAttendanceEntity.setTeacherId(teacherId);
			dailyAttendanceEntity.setDate(studentAttendanceDTO.getTimestamp());
			dailyAttendanceEntity.setStudentId(studentAttendanceDTO.getStudentId());
			dailyAttendanceEntity.setAttendanceStatus(studentAttendanceDTO.getAttendanceStatus());
			dailyAttendanceEntityList.add(dailyAttendanceEntity);
		});
		
		Iterable<DailyAttendanceEntity> returnedAttendance = attendanceRepository.saveAll(dailyAttendanceEntityList);
		if(((List<DailyAttendanceEntity>) returnedAttendance).size() == dailyAttendance.getStudentsAttendance().size())
			rvalue = true;
		return rvalue;
	}

}
