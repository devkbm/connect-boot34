package com.like.hrm.staff.application.service.dutyresponsibility;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.dto.dutyresponsibility.StaffDutyResponsibilityFormDTO;
import com.like.hrm.staff.application.port.in.dutyresponsibility.StaffDutyResponsibilitySelectUseCase;
import com.like.hrm.staff.application.port.out.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDuty;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffDutyResponsibilitySelectService implements StaffDutyResponsibilitySelectUseCase {

	StaffCommandDbPort dbPort;	
	
	StaffDutyResponsibilitySelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;		
	}

	@Override
	public StaffDutyResponsibilityFormDTO select(String companyCode, String staffNo, Long seq) {
		Staff staff = this.dbPort.select(companyCode, staffNo)
								 .orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
		StaffDuty entity = staff.getStaffDutyResponsibilityList().get(staff, seq);
				
		return StaffDutyResponsibilityFormDTO.toDTO(entity);
	}
	
	
}
