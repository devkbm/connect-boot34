package com.like.system.menu_role.domain.menu.port.out;

import java.util.List;

import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.port.in.dto.MenuQueryDTO;

public interface MenuSelectDbPort {
	Menu select(String companyCode, String menuGroupCode, String menuCode);
	
	List<Menu> selectList(MenuQueryDTO dto);
}
