package com.like.system.webresource.port.in.dto;

import lombok.Builder;

@Builder
public record WebResourceFormSelectDTO(				
		String resourceId,		
		String resourceName,
		String resourceType,		
		String url,
		String description
		) {
}
