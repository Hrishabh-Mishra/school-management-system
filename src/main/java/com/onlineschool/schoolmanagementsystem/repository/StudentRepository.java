package com.onlineschool.schoolmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.onlineschool.schoolmanagementsystem.entity.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer>{
	Optional<StudentEntity> findByEmail(String email);
	
}
