package com.like.system.webresource.port.in.app;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.webresource.port.in.WebResourceQueryUseCase;
import com.like.system.webresource.port.in.dto.WebResourceQueryDTO;
import com.like.system.webresource.port.in.dto.WebResourceQueryResultDTO;
import com.like.system.webresource.port.out.WebResourceQueryDbPort;

@Service
public class WebResourceQueryService implements WebResourceQueryUseCase {

	private WebResourceQueryDbPort port;
	
	public WebResourceQueryService(WebResourceQueryDbPort port) {
		this.port = port;		
	}	

	@Override
	public List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO dto) {	
		return this.port.getResourceList(dto);
	}
}
