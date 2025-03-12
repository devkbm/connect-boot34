package com.like.system.menu_role.application.service.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.dto.menu.MenuGroupQueryDTO;
import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTO;
import com.like.system.menu_role.application.dto.menu.MenuGroupSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.MenuGroupSelectUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuGroupSelectDbPort;

@Service
public class MenuGroupSelectService implements MenuGroupSelectUseCase {

	MenuGroupSelectDbPort port;
	
	MenuGroupSelectService(MenuGroupSelectDbPort port) {
		this.port = port;
	}
	
	@Override
	public MenuGroupSaveDTO select(String companyCode, String menuGroupCode) {
		return MenuGroupSaveDTOMapper.toDTO(this.port.select(companyCode, menuGroupCode));
	}

	@Override
	public List<MenuGroupSaveDTO> selectList(MenuGroupQueryDTO dto) {
		return this.port.selectList(dto)
						.stream()
						.map(e -> MenuGroupSaveDTOMapper.toDTO(e))
						.toList();
	}

}
