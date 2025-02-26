package com.like.system.menu_role.domain.menu.port.out;

public interface MenuDeleteDbPort {
	void delete(String companyCode, String menuGroupCode, String menuCode);
}
