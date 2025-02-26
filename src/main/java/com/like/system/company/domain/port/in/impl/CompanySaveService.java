package com.like.system.company.domain.port.in.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.company.domain.CompanyInfo;
import com.like.system.company.domain.port.in.CompanySaveUseCase;
import com.like.system.company.domain.port.in.dto.CompanyInfoSaveDTO;
import com.like.system.company.domain.port.in.dto.CompanyInfoSaveDTOMapper;
import com.like.system.company.domain.port.in.dto.CompanyInfoSaveDTOMapstruct;
import com.like.system.company.domain.port.out.CompanyCommandDbPort;

@Transactional
@Service
public class CompanySaveService implements CompanySaveUseCase {

	CompanyCommandDbPort dbPort;
	
	CompanySaveService(CompanyCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public void save(CompanyInfoSaveDTO dto) {
		//CompanyInfo entity = CompanyInfoSaveDTOMapper.toEntity(dto);
		CompanyInfo entity = CompanyInfoSaveDTOMapstruct.INSTANCE.toEntity(dto);
		
		this.dbPort.save(entity);
	}

}
