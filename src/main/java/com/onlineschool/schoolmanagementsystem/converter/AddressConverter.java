package com.onlineschool.schoolmanagementsystem.converter;

import org.springframework.context.annotation.Configuration;

import com.onlineschool.schoolmanagementsystem.dto.AddressDTO;
import com.onlineschool.schoolmanagementsystem.entity.AddressEntity;

@Configuration
public class AddressConverter {
	public AddressEntity addressDTOToEntityConverter(AddressDTO adto) {
		AddressEntity ade = new AddressEntity();
		ade.setDistrict(adto.getDistrict());
		ade.setHouseNo(adto.getHouseNo());
		ade.setLandmark(adto.getLandmark());
		ade.setLocality(adto.getLocality());
		ade.setPincode(adto.getPincode());
		ade.setPostOffice(adto.getPostOffice());
		ade.setState(adto.getPostOffice());
		ade.setStreet(adto.getStreet());
		return ade;
	}
	public AddressDTO addressEntityToDTOConverter(AddressEntity adto) {
		AddressDTO ade = new AddressDTO();
		ade.setDistrict(adto.getDistrict());
		ade.setHouseNo(adto.getHouseNo());
		ade.setLandmark(adto.getLandmark());
		ade.setLocality(adto.getLocality());
		ade.setPincode(adto.getPincode());
		ade.setPostOffice(adto.getPostOffice());
		ade.setState(adto.getPostOffice());
		ade.setStreet(adto.getStreet());
		return ade;
	}
}
