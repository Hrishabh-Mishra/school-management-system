package com.onlineschool.schoolmanagementsystem.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.onlineschool.schoolmanagementsystem.dto.StaffDTO;

@Service
//@Qualifier("staffService")
public interface AdminStaffService extends AdminCommonService<StaffDTO>{
	public StaffDTO updateSalaryStatus(StaffDTO staffDTO);//patch
	public StaffDTO updateCTC(StaffDTO staffDTO);//patch
}
