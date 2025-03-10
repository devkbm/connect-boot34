package com.like.system.menu_role.adapter.in.web.menu;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.menu_role.domain.menu.port.in.MenuGroupSaveUseCase;
import com.like.system.menu_role.domain.menu.port.in.dto.MenuGroupSaveDTO;

@RestController
public class MenuGroupSaveController {
	
	private MenuGroupSaveUseCase useCase;		
			
	public MenuGroupSaveController(MenuGroupSaveUseCase useCase) {
		this.useCase = useCase;		
	}
		
	@PostMapping("/api/system/menugroup/{id}")
	public ResponseEntity<?> saveMenuGroup(@Valid @RequestBody MenuGroupSaveDTO dto) {							
																			
		useCase.save(dto);			
										 					
		return toList(null, MessageUtil.getSaveMessage(1));
	}
}
