package com.like.system.user.domain.port.in;

import com.like.system.user.domain.port.in.dto.SystemUserSelectDTO;

public interface SystemUserSelectUseCase {
	SystemUserSelectDTO selectDTO(String userId, String companyCode);	
}
