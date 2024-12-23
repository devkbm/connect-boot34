package com.like.cooperation.board.adapter.in.web.article;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.like.cooperation.board.port.in.article.ArticleQueryByListUseCase;
import com.like.cooperation.board.port.in.article.dto.ArticleQueryDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleOneDTO;
import com.like.core.message.MessageUtil;

@Controller
public class ArticleQueryByListController {

	ArticleQueryByListUseCase useCase;
	
	ArticleQueryByListController(ArticleQueryByListUseCase useCase) {
		this.useCase = useCase;		
	}
	
	@GetMapping("/api/grw/board/article")
	public ResponseEntity<?> getArticleList(ArticleQueryDTO dto) {
																			  						
		List<ArticleOneDTO> list = useCase.getList(dto);		
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}		
}
