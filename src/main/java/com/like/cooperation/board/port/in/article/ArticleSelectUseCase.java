package com.like.cooperation.board.port.in.article;

import com.like.cooperation.board.port.in.article.dto.ArticleOneDTO;

public interface ArticleSelectUseCase {
	ArticleOneDTO select(Long id);	
}
