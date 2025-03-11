package com.like.hrm.staff.port.in.license;

import com.like.hrm.staff.port.dto.staff.license.StaffLicenseFormDTO;

public interface StaffLicenseSelectUseCase {	
	StaffLicenseFormDTO select(String companyCode, String staffNo, Long seq);
}
