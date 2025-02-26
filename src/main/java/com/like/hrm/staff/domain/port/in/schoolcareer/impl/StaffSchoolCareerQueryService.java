package com.like.hrm.staff.domain.port.in.schoolcareer.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.domain.port.in.schoolcareer.StaffSchoolCareerQueryUseCase;
import com.like.hrm.staff.domain.port.in.schoolcareer.dto.StaffSchoolCareerQueryResultDTO;
import com.like.hrm.staff.domain.port.out.StaffSchoolCareerQueryDbPort;

@Transactional(readOnly = true)
@Service
public class StaffSchoolCareerQueryService implements StaffSchoolCareerQueryUseCase {

	StaffSchoolCareerQueryDbPort dbPort;
	
	StaffSchoolCareerQueryService(StaffSchoolCareerQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public List<StaffSchoolCareerQueryResultDTO> select(String companyCode, String staffNo) {			
		return dbPort.select(companyCode, staffNo);		
	}
}
