package com.like.hrm.staff.domain.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.port.in.StaffContractSelectUseCase;
import com.like.hrm.staff.domain.port.in.dto.StaffContactSaveDTO;
import com.like.hrm.staff.domain.port.out.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;

@Service
public class StaffContractSelectService implements StaffContractSelectUseCase {

	StaffCommandDbPort dbPort;
	
	StaffContractSelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public StaffContactSaveDTO select(String companyCode, String staffNo) {
		Staff staff = dbPort.select(companyCode, staffNo).orElse(null);
		
		return StaffContactSaveDTO.toDTO(staff);
	}
}
