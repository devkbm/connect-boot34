package com.like.system.user.domain.port.in.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.export.MenuHierarchyByRolesSelectUseCase;
import com.like.system.menu_role.export.MenuHierarchyNgZorroDTO;
import com.like.system.user.domain.SystemUser;
import com.like.system.user.domain.port.in.SystemUserMenuHierarchyQueryUseCase;
import com.like.system.user.domain.port.out.SystemUserCommandDbPort;

@Service
public class SystemUserMenuHierarchyQueryService implements SystemUserMenuHierarchyQueryUseCase {
	
	SystemUserCommandDbPort dbPort;
	MenuHierarchyByRolesSelectUseCase menuHierarchySelectUseCase;	
	
	SystemUserMenuHierarchyQueryService(SystemUserCommandDbPort dbPort
									   ,MenuHierarchyByRolesSelectUseCase menuHierarchySelectUseCase) {
		this.dbPort = dbPort;
		this.menuHierarchySelectUseCase = menuHierarchySelectUseCase;		
	}
		
	@Override
	public List<MenuHierarchyNgZorroDTO> select(String companyCode, String userId, String menuGroupCode) {
		SystemUser userDTO = dbPort.select(userId);

		List<String> roleList = userDTO.getRoleList(companyCode).stream().map(e -> e.getRoleCode()).toList();
		
		return this.menuHierarchySelectUseCase.select(companyCode, menuGroupCode, roleList);
	}

}
