package com.onlineschool.schoolmanagementsystem.service.impl;

import com.onlineschool.schoolmanagementsystem.converter.AddressConverter;
import com.onlineschool.schoolmanagementsystem.converter.StudentObjectConverter;
import com.onlineschool.schoolmanagementsystem.converter.ParentObjectConverter;
import com.onlineschool.schoolmanagementsystem.dto.StudentDTO;
import com.onlineschool.schoolmanagementsystem.dto.ParentDTO;
import com.onlineschool.schoolmanagementsystem.entity.AddressEntity;
import com.onlineschool.schoolmanagementsystem.entity.ParentEntity;
import com.onlineschool.schoolmanagementsystem.entity.StudentEntity;
import com.onlineschool.schoolmanagementsystem.repository.AddressRepositry;
import com.onlineschool.schoolmanagementsystem.repository.ParentRepository;
import com.onlineschool.schoolmanagementsystem.repository.StudentRepository;
import com.onlineschool.schoolmanagementsystem.service.AdminCommonService;
import com.onlineschool.schoolmanagementsystem.service.AdminStudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.Random;
@Service
public class StudentServiceImpl implements  AdminStudentService{

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentObjectConverter studentConverter;
	@Autowired
	AddressConverter addressConverter;
	
	@Autowired
	ParentObjectConverter parentConvertor;
	
	@Autowired
	AddressRepositry addressRepositry;
	
	@Autowired 
	ParentRepository parentRepositry;
	
	@Override
	public StudentDTO fetchMarksDetails(Integer dtoObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO updateFeeStatus(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		Optional<StudentEntity> studentEntityOp = studentRepository.findById(studentDTO.getId());
		if(studentEntityOp.isPresent()) {
			StudentEntity studentEntity = studentEntityOp.get();
			studentEntity.setFeesStatus(studentDTO.getFeesStatus());
			studentRepository.save(studentEntity);
		}
		return studentDTO;
	}

	@Override
	public StudentDTO register(StudentDTO studentDTO) {
		Optional<StudentEntity> studentEntityOp = studentRepository.findByEmail(studentDTO.getEmail());
		if(studentEntityOp.isPresent()) {
			//throw error
		}
		else {
			StudentEntity studentEntity = studentConverter.studentDTOtoEntityConverter(studentDTO);
			Random random = new Random();
			int randomAddressId = random.nextInt(Integer.MAX_VALUE);
			int randomParentId1 = random.nextInt(Integer.MAX_VALUE);
			int randomParentId2 = randomParentId1+1;
			int parent1AddressId = random.nextInt(Integer.MAX_VALUE);
			int parent2AddressId = parent1AddressId+1;
			
			AddressEntity studentAddressEntity = addressConverter.addressDTOToEntityConverter(studentDTO.getAddress());
			studentAddressEntity.setAddressId(randomAddressId);
			
			ParentDTO parent1 = studentDTO.getParent1();
			ParentDTO parent2 = studentDTO.getParent2();
			
			AddressEntity parent1AddressEntity = addressConverter.addressDTOToEntityConverter(parent1.getAddress());
			parent1AddressEntity.setAddressId(parent1AddressId);
			
			AddressEntity parent2AddressEntity = addressConverter.addressDTOToEntityConverter(parent2.getAddress());
			parent2AddressEntity.setAddressId(parent2AddressId);
			
			List<AddressEntity> addressList = Arrays.asList(studentAddressEntity,parent1AddressEntity,parent2AddressEntity);
			addressRepositry.saveAll(addressList);
			
			studentAddressEntity = addressRepositry.save(studentAddressEntity);
			studentEntity.setAddressId(studentAddressEntity);
					
			studentEntity.setParentId1(randomParentId1);
			studentEntity.setParentId2(randomParentId2);
			studentEntity = studentRepository.save(studentEntity);
					
			
			ParentEntity parent1Entity = parentConvertor.parentDTOtoEntityConverter(parent1);
			parent1Entity.setParentId(randomParentId1);
			parent1Entity.setAddressId(parent1AddressEntity);
			parentRepositry.save(parent1Entity);
		
			ParentEntity parent2Entity = parentConvertor.parentDTOtoEntityConverter(parent2);
			parent2Entity.setParentId(randomParentId2);
			parent2Entity.setAddressId(parent2AddressEntity);
			parentRepositry.save(parent2Entity);
		
			studentDTO = studentConverter.studentEntitytoDTOConverter(studentEntity);
			return studentDTO;
		}
		return null;
	}


	@Override
	public StudentDTO updateDetails(StudentDTO studentDTO) {
		Optional<StudentEntity> studentEntityOp = studentRepository.findById(studentDTO.getId());
		if(studentEntityOp.isPresent()) {
			StudentEntity studentEntity = studentEntityOp.get();
			
			if(studentDTO.getStandard()!=null) {
				studentEntity.setStandard(studentDTO.getStandard());
			}
			
			if(studentDTO.getAddress()!=null) {
				AddressEntity newAddressEntity = addressConverter.addressDTOToEntityConverter(studentDTO.getAddress());
				AddressEntity oldAddressEntity = studentEntity.getAddressId();

				Random random = new Random();
				int randomAddressId = random.nextInt(Integer.MAX_VALUE);
				newAddressEntity.setAddressId(randomAddressId);
				addressRepositry.save(newAddressEntity);
				studentEntity.setAddressId(newAddressEntity);			
				
				//deleteing previous address entity
				addressRepositry.delete(oldAddressEntity);
			}
			
			if(studentDTO.getFeesStatus()!=null) {
				studentEntity.setFeesStatus(studentDTO.getFeesStatus());
			}
			if(studentDTO.getSection()!=null) {
				studentEntity.setSection(studentDTO.getSection());
			}
			if(studentDTO.getName()!=null) {
				studentEntity.setName(studentDTO.getName());
			}
			if(studentDTO.getPhone()!=null) {
				studentEntity.setPhone(studentDTO.getPhone());
			}
			if(studentDTO.getEmail()!=null) {
				studentEntity.setEmail(studentDTO.getEmail());
			}
			studentEntity = studentRepository.save(studentEntity);
			studentDTO = studentConverter.studentEntitytoDTOConverter(studentEntity);
		}
		return studentDTO;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public StudentDTO updateName(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO updateAddress(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO updateStatus(StudentDTO studentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDTO fetchDetails(Integer studentId) {
		Optional<StudentEntity> studentEntityOp = studentRepository.findById(studentId);
		StudentDTO studentDTO = null;
		if(studentEntityOp.isPresent()) {
			studentDTO = studentConverter.studentEntitytoDTOConverter(studentEntityOp.get());
		}
		return studentDTO;
	}
	@Override
	public List<StudentDTO> fetchAllStudentDetails() {
		List<StudentEntity> studentEntityList = (List<StudentEntity>) studentRepository.findAll();
		List<StudentDTO> studentDTOList = new ArrayList<>();
		for (StudentEntity studentEntity : studentEntityList) {
			studentDTOList.add(studentConverter.studentEntitytoDTOConverter(studentEntity));
		}
		return studentDTOList;
	}
}
