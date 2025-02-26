package com.like.system.menu_role.domain.role.port.in.dto;

public record RoleSaveDTO(
		String clientAppUrl,			
		String id,
		String companyCode,
		String roleCode,
		String roleName,
		String description,
		String menuGroupCode
		) {	
}
