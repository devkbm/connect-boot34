package com.like.hrm.staff.domain.port.in.license;

public interface StaffLicenseDeleteUseCase {
	void delete(String companyCode, String staffNo, Long seq);
}
