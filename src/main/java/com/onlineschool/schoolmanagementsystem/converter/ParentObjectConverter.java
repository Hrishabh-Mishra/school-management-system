package com.onlineschool.schoolmanagementsystem.converter;

import java.util.Random;

import org.springframework.context.annotation.Configuration;

import com.onlineschool.schoolmanagementsystem.dto.ParentDTO;
import com.onlineschool.schoolmanagementsystem.entity.ParentEntity;

@Configuration
public class ParentObjectConverter {

	AddressConverter addressConverter;
	
	public ParentEntity parentDTOtoEntityConverter(ParentDTO pdto) {
		ParentEntity pe = new ParentEntity();
		pe.setName(pdto.getName());
		pe.setEmail(pdto.getEmail());
		pe.setPhone(pdto.getPhone());
		pe.setPassword(pdto.getPassword());
		pe.setRelation(pdto.getRelation());
		pe.setProfession(pdto.getProfession());
		return pe;
	}
	
	public ParentDTO parentEntitytoDTOConverter(ParentEntity pe) {
		ParentDTO pdto = new ParentDTO();
		pdto.setParentId(pe.getParentId());
		pdto.setName(pe.getName());
		pdto.setEmail(pe.getEmail());
		pdto.setPhone(pe.getPhone());
		return pdto;
	}
}
