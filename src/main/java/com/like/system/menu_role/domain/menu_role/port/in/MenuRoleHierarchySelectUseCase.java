package com.like.system.menu_role.domain.menu_role.port.in;

import java.util.List;

public interface MenuRoleHierarchySelectUseCase {
	List<?> select(String companyCode, String menuGroupCode, String roleCode);
}
