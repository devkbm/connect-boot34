package com.like.system.systemcode.domain.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.domain.port.in.BizCodeDeleteUseCase;
import com.like.system.systemcode.domain.port.out.BizCodeDeletePort;

@Service
public class BizCodeDeleteService implements BizCodeDeleteUseCase {

	BizCodeDeletePort port;
	
	public BizCodeDeleteService(BizCodeDeletePort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String typeId, String code) {
		this.port.delete(companyCode, typeId, code);		
	}

	
}
