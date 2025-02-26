package com.like.system.user.domain.port.in;

import java.util.List;

import com.like.system.user.domain.port.in.dto.SystemUserSaveByExcelDTO;
import com.like.system.user.domain.port.in.dto.SystemUserSaveDTO;

public interface SystemUserSaveUseCase {
	void save(SystemUserSaveDTO dto);
	
	void save(List<SystemUserSaveByExcelDTO> dto);
}
