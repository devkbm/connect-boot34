package com.like.system.systemcode.domain.port.in;

import java.util.List;

import com.like.system.systemcode.domain.port.in.dto.BizCodeTypeSaveDTO;

public interface BizCodeTypeSelectAllUseCase {

	List<BizCodeTypeSaveDTO> select(String companyCode);
}
