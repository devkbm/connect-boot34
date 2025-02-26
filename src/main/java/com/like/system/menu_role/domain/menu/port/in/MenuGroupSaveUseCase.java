package com.like.system.menu_role.domain.menu.port.in;

import com.like.system.menu_role.domain.menu.port.in.dto.MenuGroupSaveDTO;

public interface MenuGroupSaveUseCase {
	void save(MenuGroupSaveDTO dto);
}
