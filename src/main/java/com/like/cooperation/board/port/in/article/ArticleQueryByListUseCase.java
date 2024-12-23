package com.like.cooperation.board.port.in.article;

import java.util.List;

import com.like.cooperation.board.port.in.article.dto.ArticleQueryDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleOneDTO;

public interface ArticleQueryByListUseCase {

	List<ArticleOneDTO> getList(ArticleQueryDTO dto);		
}
