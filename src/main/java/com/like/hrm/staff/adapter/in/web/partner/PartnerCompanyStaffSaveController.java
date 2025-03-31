package com.like.hrm.staff.adapter.in.web.partner;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.application.dto.staff.StaffSaveDTO;
import com.like.hrm.staff.application.port.in.staff.StaffSaveUseCase;

@RestController
public class PartnerCompanyStaffSaveController {
	
	private StaffSaveUseCase useCase;
		
	public PartnerCompanyStaffSaveController(StaffSaveUseCase useCase) {
		this.useCase = useCase;
	}		
			
	@PostMapping("/api/hrm/staff")
	public ResponseEntity<?> saveStaff(@RequestBody @Valid StaffSaveDTO dto) {			
														
		useCase.save(dto);
											 				
		return toList(null, MessageUtil.getSaveMessage(1));
	}	
			
}
