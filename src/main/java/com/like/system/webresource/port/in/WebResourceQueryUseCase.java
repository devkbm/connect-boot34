package com.like.system.webresource.port.in;

import java.util.List;

import com.like.system.webresource.port.in.dto.WebResourceQueryDTO;
import com.like.system.webresource.port.in.dto.WebResourceSelectDTO;

public interface WebResourceQueryUseCase {

	List<WebResourceSelectDTO> getResourceList(WebResourceQueryDTO condition);
}
