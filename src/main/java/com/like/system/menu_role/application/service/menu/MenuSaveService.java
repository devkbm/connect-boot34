package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.dto.menu.MenuSaveDTO;
import com.like.system.menu_role.application.dto.menu.MenuSaveDTOMapper;
import com.like.system.menu_role.application.port.in.menu.MenuSaveUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuGroupSelectDbPort;
import com.like.system.menu_role.application.port.out.menu.MenuSaveDbPort;
import com.like.system.menu_role.application.port.out.menu.MenuSelectDbPort;
import com.like.system.menu_role.domain.menu.Menu;
import com.like.system.menu_role.domain.menu.MenuGroup;

@Service
public class MenuSaveService implements MenuSaveUseCase {

	MenuSaveDbPort dbPort;
	MenuGroupSelectDbPort menuGroupDbPort;
	MenuSelectDbPort menuSelectDbPort;	
	
	MenuSaveService(MenuSaveDbPort dbPort,
				    MenuGroupSelectDbPort menuGroupDbPort,
				    MenuSelectDbPort menuSelectDbPort) {
		this.dbPort = dbPort;
		this.menuGroupDbPort = menuGroupDbPort;
		this.menuSelectDbPort = menuSelectDbPort;
	}
	
	@Override
	public void save(MenuSaveDTO dto) {
		MenuGroup menuGroup = this.menuGroupDbPort.select(dto.companyCode(), dto.menuGroupCode());
		Menu parent =  this.menuSelectDbPort.select(dto.companyCode(), dto.menuGroupCode(), dto.parentMenuCode());
		
		this.dbPort.save(MenuSaveDTOMapper.toEntity(dto, menuGroup, parent));		
	}

}
