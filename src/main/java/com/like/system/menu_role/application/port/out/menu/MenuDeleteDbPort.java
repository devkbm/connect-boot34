package com.like.system.menu_role.application.port.out.menu;

public interface MenuDeleteDbPort {
	void delete(String companyCode, String menuGroupCode, String menuCode);
}
