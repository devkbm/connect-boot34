package com.like.system.menu_role.domain.menu.port.out;

import com.like.system.menu_role.domain.menu.MenuGroup;

public interface MenuGroupSaveDbPort {
	void save(MenuGroup entity);
}
