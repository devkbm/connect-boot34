package com.like.hrm.staff.domain.port.in;

import com.like.hrm.staff.domain.port.in.dto.StaffCreateDTO;

public interface StaffCreateUseCase {
	void create(StaffCreateDTO dto);
}
