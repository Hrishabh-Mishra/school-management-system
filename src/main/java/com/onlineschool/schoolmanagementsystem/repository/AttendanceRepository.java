package com.onlineschool.schoolmanagementsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.onlineschool.schoolmanagementsystem.entity.AttendanceCompositeKey;
import com.onlineschool.schoolmanagementsystem.entity.DailyAttendanceEntity;

public interface AttendanceRepository extends CrudRepository<DailyAttendanceEntity, AttendanceCompositeKey>{
	
}
