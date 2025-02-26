package com.like.hrm.staff.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.domain.port.in.ResponseStaff;
import com.like.hrm.staff.domain.port.in.StaffSelectUseCase;

@RestController
public class StaffSelectController {
	
	private StaffSelectUseCase useCase;
		
	public StaffSelectController(StaffSelectUseCase useCase) {
		this.useCase = useCase;
	}		
	
	@GetMapping("/api/hrm/staff/{id}")
	public ResponseEntity<?> getStaff(@RequestParam String companyCode, @PathVariable String id) {
								
		ResponseStaff dto = useCase.select(companyCode, id); 
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}		
			
}
