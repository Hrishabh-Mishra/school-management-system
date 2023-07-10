package com.onlineschool.schoolmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.onlineschool.schoolmanagementsystem.entity.AddressEntity;

public interface AddressRepositry extends CrudRepository<AddressEntity, Long>{
	
}