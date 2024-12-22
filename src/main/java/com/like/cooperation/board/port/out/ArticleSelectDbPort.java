package com.like.cooperation.board.port.out;

import com.like.cooperation.board.port.in.article.dto.ArticleResponseDTO;

public interface ArticleSelectDbPort {

	ArticleResponseDTO get(Long id);
}
