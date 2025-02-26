package com.like.hrm.staff.domain.port.in;

import com.like.hrm.staff.domain.port.in.dto.StaffSaveDTO;

public interface StaffSaveUseCase {
	void save(StaffSaveDTO dto);
}
