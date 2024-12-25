package com.like.cooperation.board.port.in.article.app;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.port.in.article.ArticleSelectUseCase;
import com.like.cooperation.board.port.in.article.dto.ArticleFormSelectDTO;
import com.like.cooperation.board.port.out.ArticleSelectDbPort;

@Service
public class ArticleSelectService implements ArticleSelectUseCase {
	

	ArticleSelectDbPort port;
	
	ArticleSelectService(ArticleSelectDbPort port) {				
		this.port = port;
	}
	
	@Override
	public ArticleFormSelectDTO select(String readerUserId, Long articleId) {
		
		return this.port.get(readerUserId, articleId);
	}

}
