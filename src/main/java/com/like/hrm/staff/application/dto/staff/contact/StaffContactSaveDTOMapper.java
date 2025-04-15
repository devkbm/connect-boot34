package com.like.hrm.staff.application.dto.staff.contact;

import java.util.List;

import com.like.common.vo.Address;
import com.like.common.vo.PhoneNumber;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.contact.ContactInfo;

public class StaffContactSaveDTOMapper {

	
	public static List<ContactInfo> toEntity(Staff staff, StaffContactSaveDTO dto) {
		
		ContactInfo entity1 = new ContactInfo(
				staff, 
				"A1", 
				new Address(dto.homeAddressType(), dto.homePostNumber(), dto.homeMainAddress(), dto.homeSubAddress())
				);
		
		ContactInfo entity2 = new ContactInfo(
				staff, 
				"P1", 
				new PhoneNumber(dto.extensionNumber())
				);
		
		ContactInfo entity3 = new ContactInfo(
				staff, 
				"P2", 
				new PhoneNumber(dto.mobileNumber())
				);
		
		return List.of(entity1, entity2, entity3);
	}
}
