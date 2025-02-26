package com.like.system.user.domain.port.in;

import com.like.system.user.domain.port.in.dto.SystemUserProfileSelectDTO;
import com.like.system.user.domain.port.in.dto.SystemUserProfileSelectSessionDTO;

public interface SystemUserProfileSelectUseCase {

	SystemUserProfileSelectDTO select(String companyCode, String userId, SystemUserProfileSelectSessionDTO dto);
}
