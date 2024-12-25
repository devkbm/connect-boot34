package com.like.cooperation.board.port.in.article;

import com.like.cooperation.board.port.in.article.dto.ArticleFormSelectDTO;

public interface ArticleSelectUseCase {
	ArticleFormSelectDTO select(String readerUserId, Long articleId);	
}
