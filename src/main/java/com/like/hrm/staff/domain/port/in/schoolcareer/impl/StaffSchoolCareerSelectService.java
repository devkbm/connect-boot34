package com.like.hrm.staff.domain.port.in.schoolcareer.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.domain.port.in.schoolcareer.StaffSchoolCareerSelectUseCase;
import com.like.hrm.staff.domain.port.in.schoolcareer.dto.StaffSchoolCareerFormDTO;
import com.like.hrm.staff.domain.port.out.StaffCommandDbPort;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffSchoolCareerSelectService implements StaffSchoolCareerSelectUseCase {

	StaffCommandDbPort dbPort;
	
	StaffSchoolCareerSelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}	

	@Override
	public StaffSchoolCareerFormDTO select(String companyCode, String staffNo, Long seq) {
		Staff staff = dbPort.select(companyCode, staffNo)
							.orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
		
		return StaffSchoolCareerFormDTO.toDTO(staff.getSchoolCareerList().get(staff, seq));

	}

}
