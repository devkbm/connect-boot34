package com.like.system.webresource.port.out;

import java.util.List;


import com.like.system.webresource.port.in.dto.WebResourceQueryDTO;
import com.like.system.webresource.port.in.dto.WebResourceQueryResultDTO;

public interface WebResourceQueryDbPort {
	List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO dto);
}
