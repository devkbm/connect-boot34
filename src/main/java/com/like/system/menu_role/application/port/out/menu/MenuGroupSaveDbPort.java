package com.like.system.menu_role.application.port.out.menu;

import com.like.system.menu_role.domain.menu.MenuGroup;

public interface MenuGroupSaveDbPort {
	void save(MenuGroup entity);
}
