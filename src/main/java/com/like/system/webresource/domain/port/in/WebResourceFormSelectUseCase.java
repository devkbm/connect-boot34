package com.like.system.webresource.domain.port.in;

import com.like.system.webresource.domain.port.in.dto.WebResourceFormSelectDTO;

public interface WebResourceFormSelectUseCase {

	WebResourceFormSelectDTO select(String webResourceId);
}
