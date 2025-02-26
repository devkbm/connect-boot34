package com.like.hrm.staff.domain.port.in.license;

import java.util.List;

import com.like.hrm.staff.domain.port.in.license.dto.StaffLicenseQueryResultDTO;

public interface StaffLicenseQueryUseCase {
	List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo);
}
