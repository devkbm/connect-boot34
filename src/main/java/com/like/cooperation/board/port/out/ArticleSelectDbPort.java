package com.like.cooperation.board.port.out;

import com.like.cooperation.board.port.in.article.dto.ArticleOneDTO;

public interface ArticleSelectDbPort {

	ArticleOneDTO get(Long id);
}
