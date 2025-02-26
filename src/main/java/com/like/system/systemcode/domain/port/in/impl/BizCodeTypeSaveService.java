package com.like.system.systemcode.domain.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.system.systemcode.domain.port.in.BizCodeTypeSaveUseCase;
import com.like.system.systemcode.domain.port.in.dto.BizCodeTypeSaveDTO;
import com.like.system.systemcode.domain.port.in.dto.BizCodeTypeSaveDTOMapper;
import com.like.system.systemcode.domain.port.out.BizCodeTypeSavePort;

@Service
public class BizCodeTypeSaveService implements BizCodeTypeSaveUseCase {
	BizCodeTypeSavePort port;

	public BizCodeTypeSaveService(BizCodeTypeSavePort port) {
		this.port = port;
	}
	
	@Override
	public void save(BizCodeTypeSaveDTO dto) {
		this.port.Save(BizCodeTypeSaveDTOMapper.toEntity(dto));		
	}
}
