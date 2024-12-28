package com.like.cooperation.board.adapter.in.web.post;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.like.cooperation.board.port.in.post.PostSaveByMultiPartUseCase;
import com.like.cooperation.board.port.in.post.dto.PostSaveMultipartDTO;
import com.like.core.message.MessageUtil;

@Controller
public class PostSaveByMultiPartController {	
					
	PostSaveByMultiPartUseCase useCase;	
	
	public PostSaveByMultiPartController(PostSaveByMultiPartUseCase useCase) {				
		this.useCase = useCase;
	}	
			
	@PostMapping("/api/grw/board/article_multipart")
	@ResponseBody
	public ResponseEntity<?> saveArticleWithMultiPartFile(PostSaveMultipartDTO dto) throws Exception {													
											
		useCase.save(dto);											
		
		return toList(null, MessageUtil.getSaveMessage(1));
	}		
	
}