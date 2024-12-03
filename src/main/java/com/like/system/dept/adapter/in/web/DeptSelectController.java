package com.like.system.dept.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.dept.port.in.DeptSelectUseCase;
import com.like.system.dept.port.in.dto.DeptSaveDTO;

@RestController
public class DeptSelectController {
	
	private DeptSelectUseCase useCase;	
	
	public DeptSelectController(DeptSelectUseCase useCase) {
		this.useCase = useCase;		
	}
		
	@GetMapping("/api/system/dept/{deptCode}")
	public ResponseEntity<?> getDept(@RequestParam String companyCode, @PathVariable String deptCode) {									 
		
		DeptSaveDTO dto = useCase.select(companyCode, deptCode);
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}		
	
}
