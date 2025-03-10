package com.like.system.user.domain.port.in.impl.select;

import org.springframework.stereotype.Service;

import com.like.system.user.domain.port.in.SystemUserSelectUseCase;
import com.like.system.user.domain.port.in.dto.SystemUserSelectDTO;
import com.like.system.user.domain.port.in.dto.SystemUserSelectDTOMapper;
import com.like.system.user.domain.port.out.SystemUserCommandDbPort;

@Service
public class SystemUserSelectService implements SystemUserSelectUseCase {

	SystemUserCommandDbPort dbPort;
	
	SystemUserSelectService(SystemUserCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}	

	@Override
	public SystemUserSelectDTO selectDTO(String userId, String companyCode) {
		return SystemUserSelectDTOMapper.toDTO(this.dbPort.select(userId), companyCode);
	}
}
