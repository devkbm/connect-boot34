package com.like.system.systemcode.domain.port.in.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.domain.port.in.BizCodeTypeSelectAllUseCase;
import com.like.system.systemcode.domain.port.in.dto.BizCodeTypeSaveDTO;
import com.like.system.systemcode.domain.port.out.BizCodeTypeSelectAllPort;

@Service
public class BizCodeTypeSelectAllService implements BizCodeTypeSelectAllUseCase {

	BizCodeTypeSelectAllPort port;
	
	public BizCodeTypeSelectAllService(BizCodeTypeSelectAllPort port) {
		this.port = port;
	}

	@Override
	public List<BizCodeTypeSaveDTO> select(String companyCode) {
		return this.port.select(companyCode);
	}
	
}
