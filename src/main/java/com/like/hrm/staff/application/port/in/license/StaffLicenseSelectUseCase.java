package com.like.hrm.staff.application.port.in.license;

import com.like.hrm.staff.application.dto.license.StaffLicenseFormDTO;

public interface StaffLicenseSelectUseCase {	
	StaffLicenseFormDTO select(String companyCode, String staffNo, Long seq);
}
