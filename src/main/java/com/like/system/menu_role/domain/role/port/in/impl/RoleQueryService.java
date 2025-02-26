package com.like.system.menu_role.domain.role.port.in.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.menu_role.adapter.out.db.role.jpa.RoleJpaEntity;
import com.like.system.menu_role.domain.role.port.in.RoleQueryUseCase;
import com.like.system.menu_role.domain.role.port.in.dto.RoleQueryDTO;
import com.like.system.menu_role.domain.role.port.out.RoleQueryDbPort;

@Transactional(readOnly = true)
@Service
public class RoleQueryService implements RoleQueryUseCase {

	private RoleQueryDbPort port;
	
	public RoleQueryService(RoleQueryDbPort port) {
		this.port = port;
	}
		
	@Override
	public List<RoleJpaEntity> getAuthorityList(RoleQueryDTO condition) {
		return port.getRoleList(condition);
	}

}
