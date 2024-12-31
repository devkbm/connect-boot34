package com.like.system.webresource.port.in;

import com.like.system.webresource.port.in.dto.WebResourceFormSelectDTO;

public interface WebResourceFormSelectUseCase {

	WebResourceFormSelectDTO select(String webResourceId);
}
