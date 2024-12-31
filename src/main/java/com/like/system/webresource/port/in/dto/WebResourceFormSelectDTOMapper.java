package com.like.system.webresource.port.in.dto;

import com.like.system.webresource.domain.WebResource;

public class WebResourceFormSelectDTOMapper {

	public static WebResourceFormSelectDTO toDTO(WebResource entity) {
		
		if (entity == null) return null; 
		
		return WebResourceFormSelectDTO
					.builder()				    
				    .resourceId(entity.getId())
				    .resourceName(entity.getName())
				    .resourceType(entity.getType())
				    .url(entity.getUrl())
				    .description(entity.getDescription())
				    .build();
	}
		
}
