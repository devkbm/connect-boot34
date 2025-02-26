package com.like.system.menu_role.domain.menu_role.port.out;

import java.util.List;

import com.like.system.menu_role.domain.menu.MenuHierarchy;

public interface MenuHierarchyByRolesSelectDbPort {

	List<MenuHierarchy> select(String companyCode, String menuGroupCode, List<String> roleCodes);
}
