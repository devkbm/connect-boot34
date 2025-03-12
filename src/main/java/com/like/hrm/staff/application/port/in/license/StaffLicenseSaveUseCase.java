package com.like.hrm.staff.application.port.in.license;

import com.like.hrm.staff.application.dto.license.StaffLicenseFormDTO;

public interface StaffLicenseSaveUseCase {

	void save(StaffLicenseFormDTO dto);
}
