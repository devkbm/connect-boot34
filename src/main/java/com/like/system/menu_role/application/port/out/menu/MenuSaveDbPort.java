package com.like.system.menu_role.application.port.out.menu;

import com.like.system.menu_role.domain.menu.Menu;

public interface MenuSaveDbPort {
	void save(Menu dto);
}
