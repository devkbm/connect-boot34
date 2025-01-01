package com.like.hrm.staff.port.in.license;

import com.like.hrm.staff.port.in.license.dto.StaffLicenseSaveDTO;

public interface StaffLicenseSelectUseCase {	
	StaffLicenseSaveDTO select(String companyCode, String staffNo, Long seq);
}
