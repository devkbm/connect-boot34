package com.like.cooperation.board.port.in.article;

import com.like.cooperation.board.port.in.article.dto.ArticleResponseDTO;

public interface ArticleSelectUseCase {
	ArticleResponseDTO select(Long id);	
}
