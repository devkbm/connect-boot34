package com.like.hrm.hrmcode.adapter.in.web.hrmcodetype;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.hrmcode.application.port.in.hrmcodetype.HrmCodeTypeExtraInfoSelectUseCase;

@RestController
public class HrmCodeTypeExtraInfoSelectController {

	HrmCodeTypeExtraInfoSelectUseCase useCase;
	
	HrmCodeTypeExtraInfoSelectController(HrmCodeTypeExtraInfoSelectUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/hrmtype/{id}/extra")
	public ResponseEntity<?> getHrmType(@PathVariable String id) {
		
		List<Map<String, String>> hrmType = useCase.selectJson(id);
					
		return toList(hrmType, MessageUtil.getQueryMessage(hrmType == null ? 0 : 1));
	}
	
}
