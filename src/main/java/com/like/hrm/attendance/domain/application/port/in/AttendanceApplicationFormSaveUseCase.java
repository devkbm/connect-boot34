package com.like.hrm.attendance.domain.application.port.in;

import com.like.hrm.attendance.domain.application.port.in.dto.AttendanceApplicationFormDTO;

public interface AttendanceApplicationFormSaveUseCase {

	void save(AttendanceApplicationFormDTO dto);
}
