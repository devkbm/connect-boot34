package com.like.system.menu_role.domain.menu.port.out;

import java.util.List;

import com.like.system.menu_role.domain.menu.MenuGroup;
import com.like.system.menu_role.domain.menu.port.in.dto.MenuGroupQueryDTO;

public interface MenuGroupSelectDbPort {
	MenuGroup select(String companyCode, String menuGroupCode);
	
	List<MenuGroup> selectList(MenuGroupQueryDTO dto);
}
