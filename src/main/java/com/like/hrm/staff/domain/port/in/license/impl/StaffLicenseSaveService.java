package com.like.hrm.staff.domain.port.in.license.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.port.in.license.StaffLicenseSaveUseCase;
import com.like.hrm.staff.domain.port.in.license.dto.StaffLicenseFormDTO;
import com.like.hrm.staff.domain.port.out.StaffCommandDbPort;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.license.StaffLicense;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffLicenseSaveService implements StaffLicenseSaveUseCase {

	StaffCommandDbPort dbPort;
	
	StaffLicenseSaveService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(StaffLicenseFormDTO dto) {
		Staff staff = this.dbPort.select(dto.companyCode(), dto.staffNo())
								 .orElseThrow(() -> new EntityNotFoundException(dto.staffNo() + " 직원정보가 존재하지 않습니다."));
		StaffLicense license = staff.getLicenseList().get(staff, dto.seq());
		
		if (license == null) {
			license = dto.newEntity(staff);
		} else {
			dto.modifyEntity(license);
		}
		
		staff.getLicenseList().add(license);
		
		dbPort.save(staff);
	}

}
