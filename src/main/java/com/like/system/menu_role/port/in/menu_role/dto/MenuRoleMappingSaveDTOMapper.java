package com.like.system.menu_role.port.in.menu_role.dto;

import com.like.system.menu_role.domain.menu_role.MenuRoleMapping;
import com.like.system.menu_role.domain.menu_role.MenuRoleMappingId;

public class MenuRoleMappingSaveDTOMapper {

	public static MenuRoleMapping toEntity(MenuRoleMappingSaveDTO dto) {
		MenuRoleMapping entity = new MenuRoleMapping(new MenuRoleMappingId(dto.companyCode(), dto.menuGroupCode(), dto.menuCode(), dto.roleCode()));
		
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;
	}
}
