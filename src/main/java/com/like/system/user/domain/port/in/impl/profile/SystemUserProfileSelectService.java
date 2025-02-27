package com.like.system.user.domain.port.in.impl.profile;

import org.springframework.stereotype.Service;

import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.port.in.SystemUserProfileSelectUseCase;
import com.like.system.user.domain.port.in.dto.SystemUserProfileSelectDTO;
import com.like.system.user.domain.port.in.dto.SystemUserProfileSelectDTOMapper;
import com.like.system.user.domain.port.in.dto.SystemUserProfileSelectSessionDTO;
import com.like.system.user.domain.port.out.SystemUserCommandDbPort;

@Service
public class SystemUserProfileSelectService implements SystemUserProfileSelectUseCase {

	SystemUserCommandDbPort dbPort;	
	
	SystemUserProfileSelectService(SystemUserCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	
	@Override
	public SystemUserProfileSelectDTO select(String companyCode, String userId, SystemUserProfileSelectSessionDTO dto) {
		
		SystemUser entity = dbPort.select(userId);
								
		return SystemUserProfileSelectDTOMapper.toDTO(entity, dto);
	}

}
