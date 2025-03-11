package com.like.system.user.port.in;

import java.util.List;

import com.like.system.user.port.in.dto.SystemUserSaveByExcelDTO2;

public interface SystemUserExcelUploadUseCase {

	void save(List<SystemUserSaveByExcelDTO2> dto);
}
