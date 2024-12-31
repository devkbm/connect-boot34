package com.like.system.webresource.port.in;

import java.util.List;

import com.like.system.webresource.port.in.dto.WebResourceQueryDTO;
import com.like.system.webresource.port.in.dto.WebResourceQueryResultDTO;

public interface WebResourceQueryUseCase {

	List<WebResourceQueryResultDTO> getResourceList(WebResourceQueryDTO condition);
}
