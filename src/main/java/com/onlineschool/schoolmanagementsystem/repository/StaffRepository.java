package com.onlineschool.schoolmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.onlineschool.schoolmanagementsystem.entity.StaffEntity;

public interface StaffRepository extends CrudRepository<StaffEntity, Long>{
	Optional<StaffEntity> findByEmail(String email);
}
