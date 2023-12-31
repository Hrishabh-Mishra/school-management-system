package com.onlineschool.schoolmanagementsystem.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminCommonService<T> {
	public T register(T dtoObject);
	public T fetchDetails(Long dtoObject);//get
	public T updateName(T dtoObject);//patch
	public T updateAddress(T dtoObject);//patch
	/*status types
	 * Active
	 * Suspended
	 * Delisted
	 * */
	public T updateStatus(T dtoObject);//patch
}