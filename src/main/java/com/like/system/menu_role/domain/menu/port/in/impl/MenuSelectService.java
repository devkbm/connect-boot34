package com.like.system.menu_role.domain.menu.port.in.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.domain.menu.port.in.MenuSelectUseCase;
import com.like.system.menu_role.domain.menu.port.in.dto.MenuQueryDTO;
import com.like.system.menu_role.domain.menu.port.in.dto.MenuSaveDTO;
import com.like.system.menu_role.domain.menu.port.in.dto.MenuSaveDTOMapper;
import com.like.system.menu_role.domain.menu.port.out.MenuSelectDbPort;

@Service
public class MenuSelectService implements MenuSelectUseCase {

	MenuSelectDbPort port;
	
	MenuSelectService(MenuSelectDbPort port) {
		this.port = port;
	}
	
	@Override
	public MenuSaveDTO select(String companyCode, String menuGroupCode, String menuCode) {
		return MenuSaveDTOMapper.toDTO(this.port.select(companyCode, menuGroupCode, menuCode));
	}

	@Override
	public List<MenuSaveDTO> selectList(MenuQueryDTO dto) {
		return this.port.selectList(dto)
						.stream()
						.map(e -> MenuSaveDTOMapper.toDTO(e))
						.toList();
	}

}
