package com.like.system.systemcode.domain.port.out;

import com.like.system.systemcode.domain.BizCodeType;
import com.like.system.systemcode.domain.port.in.dto.BizCodeTypeSaveDTO;

public interface BizCodeTypeSelectPort {
	BizCodeType select(String companyCode, String typeId);
	
	BizCodeTypeSaveDTO selectDTO(String companyCode, String typeId);	
}
