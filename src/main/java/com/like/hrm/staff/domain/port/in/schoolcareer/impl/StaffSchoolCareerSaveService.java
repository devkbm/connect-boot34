package com.like.hrm.staff.domain.port.in.schoolcareer.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.domain.port.in.schoolcareer.StaffSchoolCareerSaveUseCase;
import com.like.hrm.staff.domain.port.in.schoolcareer.dto.StaffSchoolCareerFormDTO;
import com.like.hrm.staff.domain.port.out.StaffCommandDbPort;
import com.like.hrm.staff.domain.schoolcareer.StaffSchoolCareer;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffSchoolCareerSaveService implements StaffSchoolCareerSaveUseCase {

	StaffCommandDbPort dbPort;
	
	StaffSchoolCareerSaveService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;				
	}
	
	@Override
	public void save(StaffSchoolCareerFormDTO dto) {
		Staff staff = dbPort.select(dto.companyCode(), dto.staffNo())
							.orElseThrow(() -> new EntityNotFoundException(dto.staffNo() + " 직원정보가 존재하지 않습니다."));
		StaffSchoolCareer education = staff.getSchoolCareerList().get(staff, dto.seq());
		
		if (education == null) {
			education = dto.newEntity(staff);
		} else {
			dto.modifyEnity(education);
		}
		
		staff.getSchoolCareerList().add(education);
		
		dbPort.save(staff);
	}

}
