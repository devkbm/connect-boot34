package com.like.hrm.staff.port.in.license.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.port.in.license.StaffLicenseQueryUseCase;
import com.like.hrm.staff.port.in.license.dto.StaffLicenseQueryResultDTO;
import com.like.hrm.staff.port.out.StaffLicenseQueryDbPort;

@Transactional(readOnly = true)
@Service
public class StaffLicenseQueryService implements StaffLicenseQueryUseCase {

	StaffLicenseQueryDbPort dbPort;
	
	StaffLicenseQueryService(StaffLicenseQueryDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo) {				
		return dbPort.select(companyCode, staffNo);		
	}
}
