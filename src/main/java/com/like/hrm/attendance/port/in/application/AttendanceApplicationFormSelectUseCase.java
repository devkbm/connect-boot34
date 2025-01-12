package com.like.hrm.attendance.port.in.application;

import com.like.hrm.attendance.port.in.application.dto.AttendanceApplicationFormDTO;

public interface AttendanceApplicationFormSelectUseCase {

	AttendanceApplicationFormDTO select(Long id);
}
