package com.like.system.webresource.port.in;

import com.like.system.webresource.port.in.dto.WebResourceSaveDTO;

public interface WebResourceFormSelectUseCase {

	WebResourceSaveDTO select(String webResourceId);
}
