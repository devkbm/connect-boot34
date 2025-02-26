package com.like.system.company.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.company.domain.port.in.CompanySelectUseCase;
import com.like.system.company.domain.port.in.dto.CompanyInfoSaveDTO;

@RestController
public class CompanySelectController {

	CompanySelectUseCase useCase;
	
	CompanySelectController(CompanySelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/system/company/{companyCode}")
	public ResponseEntity<?> getCompany(@PathVariable String companyCode) {									 
		
		CompanyInfoSaveDTO dto = useCase.select(companyCode);
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
}
