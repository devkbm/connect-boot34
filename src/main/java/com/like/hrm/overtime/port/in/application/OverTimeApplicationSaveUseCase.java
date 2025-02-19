package com.like.hrm.overtime.port.in.application;

import com.like.hrm.overtime.port.in.application.dto.OverTimeApplicationFormDTO;

public interface OverTimeApplicationSaveUseCase {
	void save(OverTimeApplicationFormDTO dto);
}
