package com.like.hrm.staff.application.service.license;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.application.dto.license.StaffLicenseQueryResultDTO;
import com.like.hrm.staff.application.port.in.license.StaffLicenseQueryUseCase;
import com.like.hrm.staff.application.port.out.StaffLicenseQueryDbPort;

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
