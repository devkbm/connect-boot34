package com.like.system.systemcode.domain.port.in;

import com.like.system.systemcode.domain.port.in.dto.BizCodeTypeSaveDTO;

public interface BizCodeTypeSelectUseCase {
	
	BizCodeTypeSaveDTO select(String companyCode, String typeId);
}
