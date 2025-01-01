package com.like.hrm.staff.port.in.license;

import java.util.List;

import com.like.hrm.staff.port.in.license.dto.StaffLicenseQueryResultDTO;

public interface StaffLicenseQueryUseCase {
	List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo);
}
