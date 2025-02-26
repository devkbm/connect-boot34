package com.like.system.menu_role.domain.menu.port.out;

import com.like.system.menu_role.domain.menu.Menu;

public interface MenuSaveDbPort {
	void save(Menu dto);
}
