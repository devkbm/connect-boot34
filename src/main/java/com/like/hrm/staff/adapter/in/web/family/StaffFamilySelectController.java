package com.like.hrm.staff.adapter.in.web.family;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.port.dto.staff.family.StaffFamilyFormDTO;
import com.like.hrm.staff.port.in.family.StaffFamilySelectUseCase;


@RestController
public class StaffFamilySelectController {

	private StaffFamilySelectUseCase useCase;
		
	public StaffFamilySelectController(StaffFamilySelectUseCase useCase) {
		this.useCase = useCase;	
	}	
	
	@GetMapping("/api/hrm/staff/{staffId}/family/{seq}")
	public ResponseEntity<?> getFamily(@RequestParam String companyCode
									  ,@PathVariable String staffId
									  ,@PathVariable Long seq) {				
				
		StaffFamilyFormDTO dto =  useCase.select(companyCode, staffId, seq);
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));							
	}
}
