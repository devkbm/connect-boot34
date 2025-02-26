package com.like.system.menu_role.domain.menu.port.in;

import java.util.List;

public interface MenuHierarchySelectUseCase {

	List<MenuHierarchyNgZorro> select(String companyCode, String menuGroupCode);	
}
