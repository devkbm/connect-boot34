package com.like.hrm.staff.port.in;

import com.like.hrm.staff.port.dto.staff.StaffContactSaveDTO;

public interface StaffContractSelectUseCase {

	StaffContactSaveDTO select(String companyCode, String staffNo);
}
