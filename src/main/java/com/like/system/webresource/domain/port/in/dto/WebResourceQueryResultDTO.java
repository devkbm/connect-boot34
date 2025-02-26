package com.like.system.webresource.domain.port.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WebResourceQueryResultDTO {				
		String resourceId;		
		String resourceName;
		String resourceType;		
		String url;
		String description;
		
}
