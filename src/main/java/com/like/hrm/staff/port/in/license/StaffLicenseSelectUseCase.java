package com.like.hrm.staff.port.in.license;

import com.like.hrm.staff.port.in.license.dto.StaffLicenseFormDTO;

public interface StaffLicenseSelectUseCase {	
	StaffLicenseFormDTO select(String companyCode, String staffNo, Long seq);
}
