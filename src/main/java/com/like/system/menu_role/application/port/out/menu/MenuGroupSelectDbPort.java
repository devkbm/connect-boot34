package com.like.system.menu_role.application.port.out.menu;

import java.util.List;

import com.like.system.menu_role.application.dto.menu.MenuGroupQueryDTO;
import com.like.system.menu_role.domain.menu.MenuGroup;

public interface MenuGroupSelectDbPort {
	MenuGroup select(String companyCode, String menuGroupCode);
	
	List<MenuGroup> selectList(MenuGroupQueryDTO dto);
}
