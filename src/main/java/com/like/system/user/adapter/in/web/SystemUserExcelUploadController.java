package com.like.system.user.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.like.core.message.MessageUtil;
import com.like.system.user.domain.port.in.SystemUserSaveUseCase;
import com.like.system.user.domain.port.in.dto.SystemUserSaveByExcelDTO;
import com.like.system.user.domain.port.in.impl.save.SystemUserSaveByExcelDTOMapper;

@Controller
public class SystemUserExcelUploadController {

	SystemUserSaveUseCase useCase;
	
	public SystemUserExcelUploadController(SystemUserSaveUseCase useCase) {		
		this.useCase = useCase;
	}		
	
	@PostMapping("/api/system/user-excel")	
	public ResponseEntity<?> ss(MultipartFile file) {
		
		List<SystemUserSaveByExcelDTO> list = SystemUserSaveByExcelDTOMapper.map(file);
		
		useCase.save(list);
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
