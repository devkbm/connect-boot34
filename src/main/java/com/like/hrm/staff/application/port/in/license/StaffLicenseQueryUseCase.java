package com.like.hrm.staff.application.port.in.license;

import java.util.List;

import com.like.hrm.staff.application.dto.license.StaffLicenseQueryResultDTO;

public interface StaffLicenseQueryUseCase {
	List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo);
}
