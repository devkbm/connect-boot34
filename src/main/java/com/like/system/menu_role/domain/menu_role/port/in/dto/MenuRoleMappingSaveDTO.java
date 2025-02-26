package com.like.system.menu_role.domain.menu_role.port.in.dto;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record MenuRoleMappingSaveDTO(
		LocalDateTime createdDt,
		String createdBy,
		LocalDateTime modifiedDt,
		String modifiedBy,
		String clientAppUrl,	
		String companyCode,
		String menuGroupCode,
		String menuCode,
		String roleCode
		) {
	
}
