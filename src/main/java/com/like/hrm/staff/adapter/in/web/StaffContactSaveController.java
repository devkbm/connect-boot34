package com.like.hrm.staff.adapter.in.web;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.domain.port.in.StaffContractSaveUseCase;
import com.like.hrm.staff.domain.port.in.dto.StaffContactSaveDTO;

@RestController
public class StaffContactSaveController {

	private StaffContractSaveUseCase useCase;
	
	public StaffContactSaveController(StaffContractSaveUseCase useCase) {
		this.useCase = useCase;
	}
	
	@PostMapping("/api/hrm/staff/{staffId}/contact")
	public ResponseEntity<?> saveAppointmentRecord(@Valid @RequestBody StaffContactSaveDTO dto) {			
									
		useCase.save(dto);
		
		return toList(null, MessageUtil.getSaveMessage(1));
	}
}
