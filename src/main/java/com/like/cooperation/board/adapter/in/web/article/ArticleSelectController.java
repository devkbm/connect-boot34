package com.like.cooperation.board.adapter.in.web.article;

import jakarta.servlet.http.HttpSession;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.like.cooperation.board.port.in.article.ArticleSelectUseCase;
import com.like.cooperation.board.port.in.article.dto.ArticleResponseDTO;
import com.like.cooperation.board.util.Base64Util;
import com.like.core.message.MessageUtil;

@Controller
public class ArticleSelectController {	
			
	ArticleSelectUseCase useCase;
	
	public ArticleSelectController(ArticleSelectUseCase useCase) {		
		this.useCase = useCase;
	}		
	
	@GetMapping("/api/grw/board/article/{id}")
	public ResponseEntity<?> getArticle(@PathVariable String id, HttpSession session) {						
							
		Long decodedId = Base64Util.fromBase64Decode(id);
		
		ArticleResponseDTO response =  useCase.select(decodedId);				
		
		return toOne(response, MessageUtil.getQueryMessage(response == null ? 0 : 1));
	}
			
}
