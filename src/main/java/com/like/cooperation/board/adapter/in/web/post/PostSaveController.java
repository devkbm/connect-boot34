package com.like.cooperation.board.adapter.in.web.post;

import jakarta.validation.Valid;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.like.cooperation.board.application.dto.post.PostFormSaveDTO;
import com.like.cooperation.board.application.port.in.post.PostSaveByJsonUseCase;
import com.like.core.message.MessageUtil;

@Controller
public class PostSaveController {	
					
	PostSaveByJsonUseCase useCase;	
	
	public PostSaveController(PostSaveByJsonUseCase useCase) {				
		this.useCase = useCase;
	}	
					
	@PostMapping("/api/grw/board/post")
	@ResponseBody
	public ResponseEntity<?> saveArticleJson(@RequestBody @Valid PostFormSaveDTO dto) throws Exception {															
										
		Long postId = useCase.save(dto);											
		
		return toOne(postId, MessageUtil.getSaveMessage(1));
	}	
	
}
