package com.like.hrm.staff.application.port.out;

import java.util.List;

import com.like.hrm.staff.application.dto.license.StaffLicenseQueryResultDTO;

public interface StaffLicenseQueryDbPort {
	List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo);
}
