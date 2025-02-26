package com.like.system.menu_role.domain.role.port.in;

import com.like.system.menu_role.domain.role.Role;

public interface RoleSelectUseCase {
	Role select(String companyCode, String roleCode);
}
