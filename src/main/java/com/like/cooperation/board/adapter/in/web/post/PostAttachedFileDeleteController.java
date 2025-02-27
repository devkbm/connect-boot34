package com.like.cooperation.board.adapter.in.web.post;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.like.cooperation.board.domain.post.port.in.PostAttachedFileDeleteUseCase;
import com.like.core.message.MessageUtil;

@Controller
public class PostAttachedFileDeleteController {

	PostAttachedFileDeleteUseCase useCase;
	
	PostAttachedFileDeleteController(PostAttachedFileDeleteUseCase useCase) {
		this.useCase = useCase;
	}
	
	
	@DeleteMapping("/api/grw/board/post/{id}/file/{fileId}")
	public ResponseEntity<?> delete(@PathVariable String id, @PathVariable String fileId) {				
												
		useCase.delete(id, fileId);							
		
		return toList(null, MessageUtil.getDeleteMessage(1));
	}
}
