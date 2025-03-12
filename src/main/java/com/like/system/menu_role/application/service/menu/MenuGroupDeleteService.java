package com.like.system.menu_role.application.service.menu;

import org.springframework.stereotype.Service;

import com.like.system.menu_role.application.port.in.menu.MenuGroupDeleteUseCase;
import com.like.system.menu_role.application.port.out.menu.MenuGroupDeleteDbPort;

@Service
public class MenuGroupDeleteService implements MenuGroupDeleteUseCase {

	MenuGroupDeleteDbPort port;
	
	MenuGroupDeleteService(MenuGroupDeleteDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(String companyCode, String menuGroupCode) {
		this.port.delete(companyCode, menuGroupCode);
	}

}
