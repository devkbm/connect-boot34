package com.like.hrm.staff.domain.port.in.license;

import com.like.hrm.staff.domain.port.in.license.dto.StaffLicenseFormDTO;

public interface StaffLicenseSaveUseCase {

	void save(StaffLicenseFormDTO dto);
}
