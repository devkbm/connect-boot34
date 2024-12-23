package com.like.cooperation.board.port.out;

import java.util.List;

import com.like.cooperation.board.port.in.article.dto.ArticleQueryDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleOneDTO;

public interface ArticleQueryByListDbPort {

	List<ArticleOneDTO> getList(ArticleQueryDTO dto);		
}
