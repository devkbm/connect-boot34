package com.like.system.webresource.domain.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.system.webresource.domain.port.in.WebResourceFormSaveUseCase;
import com.like.system.webresource.domain.port.in.dto.WebResourceSaveDTO;
import com.like.system.webresource.domain.port.in.dto.WebResourceSaveDTOMapper;
import com.like.system.webresource.domain.port.out.WebResourceCommandDbPort;

@Service
public class WebResourceFormSaveService implements WebResourceFormSaveUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceFormSaveService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void save(WebResourceSaveDTO dto) {
		this.port.save(WebResourceSaveDTOMapper.toEntity(dto));		
	}
}
