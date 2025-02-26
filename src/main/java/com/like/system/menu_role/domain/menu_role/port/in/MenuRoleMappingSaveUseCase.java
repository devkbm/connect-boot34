package com.like.system.menu_role.domain.menu_role.port.in;

import java.util.List;

import com.like.system.menu_role.domain.menu_role.port.in.dto.MenuRoleMappingSaveDTO;

public interface MenuRoleMappingSaveUseCase {

	void save(List<MenuRoleMappingSaveDTO> entityList);
}
