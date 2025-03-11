package com.like.hrm.staff.port.in.dutyresponsibility.impl;

import org.springframework.stereotype.Service;

import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.dutyresponsibility.StaffDuty;
import com.like.hrm.staff.port.dto.staff.dutyresponsibility.StaffDutyResponsibilityFormDTO;
import com.like.hrm.staff.port.in.dutyresponsibility.StaffDutyResponsibilitySaveUseCase;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StaffDutyResponsibilitySaveService implements StaffDutyResponsibilitySaveUseCase {

	StaffCommandDbPort dbPort;
	
	StaffDutyResponsibilitySaveService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(StaffDutyResponsibilityFormDTO dto) {
		Staff staff = this.dbPort.select(dto.companyCode(), dto.staffNo())
								 .orElseThrow(() -> new EntityNotFoundException(dto.staffNo() + " 직원정보가 존재하지 않습니다."));
		StaffDuty entity = staff.getStaffDutyResponsibilityList().get(staff, dto.seq());
		
		if (entity == null) {
			entity = dto.newEntity(staff);
		} else {
			dto.modifyEntity(entity);
		}
		
		this.dbPort.save(staff);		
	}

}
