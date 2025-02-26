package com.like.system.webresource.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.like.system.webresource.domain.port.in.WebResourceFormDeleteUseCase;

@RestController
public class WebResourceFormDeleteController {

	private WebResourceFormDeleteUseCase useCase;
	
	public WebResourceFormDeleteController(WebResourceFormDeleteUseCase useCase) {
		this.useCase = useCase;		
	}	
	
	@DeleteMapping("/api/system/webresource/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {				
												
		useCase.delete(id);							
		
		return toOne(null, String.format("%d 건 삭제되었습니다.", 1));
	}
}
