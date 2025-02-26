package com.like.system.user.domain.port.out;

import java.util.List;

import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.port.in.dto.SystemUserQueryDTO;

public interface SystemUserQueryDbPort {
	List<SystemUser> selectList(SystemUserQueryDTO dto);
}
