package com.like.hrm.staff.port.out;

import java.util.List;

import com.like.hrm.staff.port.in.license.dto.StaffLicenseQueryResultDTO;

public interface StaffLicenseQueryDbPort {
	List<StaffLicenseQueryResultDTO> select(String companyCode, String staffNo);
}
