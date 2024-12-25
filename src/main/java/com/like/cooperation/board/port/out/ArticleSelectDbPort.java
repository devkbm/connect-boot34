package com.like.cooperation.board.port.out;

import com.like.cooperation.board.port.in.article.dto.ArticleFormSelectDTO;

public interface ArticleSelectDbPort {

	ArticleFormSelectDTO get(String readerUserId, Long articleId);
}
