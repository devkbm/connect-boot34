package com.like.hrm.staff.port.in;

import java.util.Optional;

import com.like.common.vo.Address;
import com.like.common.vo.PhoneNumber;
import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.domain.StaffContact;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record StaffContactSaveDTO(
		String clientAppUrl,
		String companyCode,						
		@NotEmpty String staffNo,
		String staffName,
		String homeAddressType,
		String homePostNumber,
		String homeMainAddress,
		String homeSubAddress,
		String extensionNumber,
		String mobileNumber
		) {
	
	public StaffContact newEntity() {		
		return new StaffContact(new Address(homeAddressType, homePostNumber, homeMainAddress, extensionNumber), new PhoneNumber(extensionNumber), new PhoneNumber(mobileNumber));
	}
				
	public static StaffContactSaveDTO toDTO(Staff entity) {			
		if (entity == null) return null;
		
		Optional<StaffContact> contact = Optional.ofNullable(entity.getContact());
							
		return StaffContactSaveDTO.builder()
						  .companyCode(entity.getId().companyCode())	
				 		  .staffNo(entity.getId().staffNo())
				 		  .homeAddressType(contact.map(StaffContact::getHome).map(Address::getAddress_type).orElse(null))
				 		  .homePostNumber(contact.map(StaffContact::getHome).map(Address::getPost_number).orElse(null))
				 		  .homeMainAddress(contact.map(StaffContact::getHome).map(Address::getMain_address).orElse(null))
				 		  .homeSubAddress(contact.map(StaffContact::getHome).map(Address::getSub_address).orElse(null))					 		  
				 		  .extensionNumber(contact.map(StaffContact::getExtensionNumber).map(PhoneNumber::getNumber).orElse(null))
				 		  .mobileNumber(contact.map(StaffContact::getMobileNumber).map(PhoneNumber::getNumber).orElse(null))					 		  					 		  					 		  					 		
						  .build();
						  
	}
}