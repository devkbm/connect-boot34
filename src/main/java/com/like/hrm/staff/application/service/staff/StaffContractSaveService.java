package com.like.hrm.staff.application.service.staff;

import org.springframework.stereotype.Service;

import com.like.common.vo.Address;
import com.like.common.vo.PhoneNumber;
import com.like.hrm.staff.application.dto.staff.StaffContactSaveDTO;
import com.like.hrm.staff.application.port.in.staff.StaffContractSaveUseCase;
import com.like.hrm.staff.application.port.out.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.StaffContact;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffContractSaveService implements StaffContractSaveUseCase {

	StaffCommandDbPort dbPort;
	
	StaffContractSaveService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public void save(StaffContactSaveDTO dto) {
		Staff staff = dbPort.select(dto.companyCode(), dto.staffNo())
							.orElseThrow(() -> new EntityNotFoundException("직원정보가 존재하지 않습니다."));;
		
		staff.changeContact(new StaffContact(new Address(dto.homeAddressType(), dto.homePostNumber(), dto.homeMainAddress(), dto.homeSubAddress())
						   ,new PhoneNumber(dto.extensionNumber())
						   ,new PhoneNumber(dto.mobileNumber())));
		
		this.dbPort.save(staff);
	}
	
}
