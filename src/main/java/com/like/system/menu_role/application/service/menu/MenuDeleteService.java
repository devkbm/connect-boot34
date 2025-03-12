package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.menu.MenuDeleteUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuDeleteDbPort;

@Service
public class MenuDeleteService implements MenuDeleteUseCase {

	MenuDeleteDbPort port;
	
	MenuDeleteService(MenuDeleteDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String menuGroupCode, String menuCode) {
		this.port.delete(companyCode, menuGroupCode, menuCode);		
	}

}
