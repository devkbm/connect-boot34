package com.like.system.systemcode.domain.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.domain.port.in.BizCodeTypeDeleteUseCase;
import com.like.system.systemcode.domain.port.out.BizCodeTypeDeletePort;

@Service
public class BizCodeTypeDeleteService implements BizCodeTypeDeleteUseCase {

	BizCodeTypeDeletePort port;
	
	public BizCodeTypeDeleteService(BizCodeTypeDeletePort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String typeId) {
		this.port.delete(companyCode, typeId);		
	}
	
	
}
