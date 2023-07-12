package com.onlineschool.schoolmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.onlineschool.schoolmanagementsystem.entity.ParentEntity;

public interface ParentRepository extends CrudRepository<ParentEntity, Integer>{
	Optional<ParentEntity> findByEmail(String email);
	
}
