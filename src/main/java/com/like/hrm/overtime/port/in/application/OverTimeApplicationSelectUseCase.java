package com.like.hrm.overtime.port.in.application;

import com.like.hrm.overtime.port.in.application.dto.OverTimeApplicationFormDTO;

public interface OverTimeApplicationSelectUseCase {
	OverTimeApplicationFormDTO select(Long id);
}
