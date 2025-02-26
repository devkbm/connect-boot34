package com.like.system.menu_role.domain.menu.port.in;

import com.like.system.menu_role.domain.menu.port.in.dto.MenuSaveDTO;

public interface MenuSaveUseCase {
	void save(MenuSaveDTO dto);
}
