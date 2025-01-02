package com.like.system.webresource.port.in.app;

import org.springframework.stereotype.Service;

import com.like.system.webresource.port.in.WebResourceFormDeleteUseCase;
import com.like.system.webresource.port.out.WebResourceCommandDbPort;

@Service
public class WebResourceFormDeleteService implements WebResourceFormDeleteUseCase {

	WebResourceCommandDbPort port;
	
	WebResourceFormDeleteService(WebResourceCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String webResourceId) {
		this.port.delete(webResourceId);		
	}
	
}