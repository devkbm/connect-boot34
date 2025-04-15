package com.like.hrm.staff.application.service.staff.contact;

import org.springframework.stereotype.Service;

import com.like.common.vo.Address;
import com.like.common.vo.PhoneNumber;
import com.like.hrm.staff.application.dto.staff.contact.StaffContactSaveDTO;
import com.like.hrm.staff.application.dto.staff.contact.StaffContactSaveDTOMapper;
import com.like.hrm.staff.application.port.in.staff.StaffContractSaveUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.application.port.out.staff.StaffContactInfoCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.StaffContact;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffContractSaveService implements StaffContractSaveUseCase {

	StaffCommandDbPort dbPort;
	StaffContactInfoCommandDbPort dbPort2;
	
	StaffContractSaveService(StaffCommandDbPort dbPort, StaffContactInfoCommandDbPort dbPort2) {
		this.dbPort = dbPort;
		this.dbPort2 = dbPort2;
	}

	@Override
	public void save(StaffContactSaveDTO dto) {
		Staff staff = dbPort.select(dto.companyCode(), dto.staffNo())
							.orElseThrow(() -> new EntityNotFoundException("직원정보가 존재하지 않습니다."));;
		
		staff.changeContact(new StaffContact(new Address(dto.homeAddressType(), dto.homePostNumber(), dto.homeMainAddress(), dto.homeSubAddress())
						   ,new PhoneNumber(dto.extensionNumber())
						   ,new PhoneNumber(dto.mobileNumber())));					
		
		this.dbPort.save(staff);
		
		this.dbPort2.save(StaffContactSaveDTOMapper.toEntity(staff, dto));		
	}
	
}
