package com.like.system.user.domain.port.in;

import com.like.system.user.domain.port.in.dto.SystemUserPasswordChangeDTO;

public interface SystemUserPasswordChangeUseCase {
	void changePassword(SystemUserPasswordChangeDTO dto);
}
