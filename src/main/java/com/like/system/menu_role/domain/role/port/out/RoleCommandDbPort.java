package com.like.system.menu_role.domain.role.port.out;

import com.like.system.menu_role.domain.role.Role;

public interface RoleCommandDbPort {
	Role find(String companyCode, String roleCode);
	
	void save(Role entity);
	
	void delete(String companyCode, String roleCode);
}
