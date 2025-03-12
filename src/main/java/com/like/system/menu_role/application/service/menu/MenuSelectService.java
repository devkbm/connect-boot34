package com.like.system.menu_role.application.service.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.dto.menu.MenuQueryDTO;
import com.like.system.menu_role.application.dto.menu.MenuSaveDTO;
import com.like.system.menu_role.application.dto.menu.MenuSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.MenuSelectUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuSelectDbPort;

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
