package com.like.hrm.staff.application.service.staff;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.dto.staff.StaffContactSaveDTO;
import com.like.hrm.staff.application.port.in.staff.StaffContractSelectUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
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
