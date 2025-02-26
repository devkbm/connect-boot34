package com.like.hrm.staff.domain.port.in;

import com.like.hrm.staff.domain.port.in.dto.StaffContactSaveDTO;

public interface StaffContractSelectUseCase {

	StaffContactSaveDTO select(String companyCode, String staffNo);
}
