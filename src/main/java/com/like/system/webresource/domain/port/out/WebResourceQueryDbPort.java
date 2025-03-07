package com.like.system.webresource.domain.port.out;

import java.util.List;

import com.like.system.webresource.domain.port.in.dto.WebResourceQueryDTO;
import com.like.system.webresource.domain.port.in.dto.WebResourceQueryResultDTO;

public interface WebResourceQueryDbPort {
	List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO dto);
}
