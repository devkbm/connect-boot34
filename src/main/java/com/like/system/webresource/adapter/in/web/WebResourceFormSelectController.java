package com.like.system.webresource.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.system.webresource.application.dto.WebResourceFormSelectDTO;
import com.like.system.webresource.application.port.in.WebResourceFormSelectUseCase;

@RestController
public class WebResourceFormSelectController {

	private WebResourceFormSelectUseCase useCase;
	
	public WebResourceFormSelectController(WebResourceFormSelectUseCase useCase) {
		this.useCase = useCase;		
	}
	
	@GetMapping("/api/system/webresource/{id}")
	public ResponseEntity<?> select(@PathVariable String id) {				
				 							
		WebResourceFormSelectDTO dto = this.useCase.select(id);
		
		return toOne(dto, String.format("%d 건 조회되었습니다.", dto != null ? 1 : 0));
	}	
}
