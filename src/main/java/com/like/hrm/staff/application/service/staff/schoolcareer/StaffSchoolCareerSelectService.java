package com.like.hrm.staff.application.service.staff.schoolcareer;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.application.dto.staff.schoolcareer.StaffSchoolCareerFormDTO;
import com.like.hrm.staff.application.port.in.staff.schoolcareer.StaffSchoolCareerSelectUseCase;
import com.like.hrm.staff.application.port.out.staff.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;

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
