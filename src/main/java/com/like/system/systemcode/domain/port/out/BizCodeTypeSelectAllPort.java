package com.like.system.systemcode.domain.port.out;

import java.util.List;

import com.like.system.systemcode.domain.port.in.dto.BizCodeTypeSaveDTO;

public interface BizCodeTypeSelectAllPort {
	List<BizCodeTypeSaveDTO> select(String companyCode);
}
