package com.like.system.webresource.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.webresource.port.in.WebResourceFormSelectUseCase;
import com.like.system.webresource.port.in.dto.WebResourceFormSelectDTO;
import com.like.system.webresource.port.in.dto.WebResourceFormSelectDTOMapper;
import com.like.system.webresource.port.out.WebResourceCommandDbPort;

@Service
public class WebResourceFormSelectService implements WebResourceFormSelectUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceFormSelectService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public WebResourceFormSelectDTO select(String id) {
		return WebResourceFormSelectDTOMapper.toDTO(this.port.select(id));
	}

}
