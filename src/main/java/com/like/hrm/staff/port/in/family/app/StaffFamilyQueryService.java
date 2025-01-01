package com.like.hrm.staff.port.in.family.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.port.in.family.StaffFamilyQueryUseCase;
import com.like.hrm.staff.port.in.family.dto.StaffFamilyQueryResultDTO;
import com.like.hrm.staff.port.out.StaffFamilyQueryDbPort;

@Transactional(readOnly = true)
@Service
public class StaffFamilyQueryService implements StaffFamilyQueryUseCase {

	StaffFamilyQueryDbPort dbPort;
	
	StaffFamilyQueryService(StaffFamilyQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public List<StaffFamilyQueryResultDTO> select(String companyCode, String staffNo) {
		
		return this.dbPort.select(companyCode, staffNo);
	}
}
