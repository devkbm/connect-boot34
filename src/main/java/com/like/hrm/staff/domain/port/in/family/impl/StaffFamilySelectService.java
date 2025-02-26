package com.like.hrm.staff.domain.port.in.family.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.port.in.family.StaffFamilySelectUseCase;
import com.like.hrm.staff.domain.port.in.family.dto.StaffFamilyFormDTO;
import com.like.hrm.staff.domain.port.out.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffFamilySelectService implements StaffFamilySelectUseCase {

	StaffCommandDbPort dbPort;
	
	StaffFamilySelectService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public StaffFamilyFormDTO select(String companyCode, String staffNo, Long seq) {
		Staff staff = dbPort.select(companyCode, staffNo)
							.orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
		return StaffFamilyFormDTO.toDTO(staff.getFamilyList().get(staff, seq));
	}
}
