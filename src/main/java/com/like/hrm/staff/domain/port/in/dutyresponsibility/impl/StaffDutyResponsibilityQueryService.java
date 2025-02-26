package com.like.hrm.staff.domain.port.in.dutyresponsibility.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.domain.port.in.dutyresponsibility.StaffDutyResponsibilityQueryUseCase;
import com.like.hrm.staff.domain.port.in.dutyresponsibility.dto.StaffDutyResponsibilityQueryResultDTO;
import com.like.hrm.staff.domain.port.out.StaffDutyResponsibilityQueryDbPort;

@Transactional(readOnly = true)
@Service
public class StaffDutyResponsibilityQueryService implements StaffDutyResponsibilityQueryUseCase {

	StaffDutyResponsibilityQueryDbPort dbPort;
	
	StaffDutyResponsibilityQueryService(StaffDutyResponsibilityQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public List<StaffDutyResponsibilityQueryResultDTO> select(String companyCode, String staffNo) {
		return this.dbPort.select(companyCode, staffNo);
	}
}
