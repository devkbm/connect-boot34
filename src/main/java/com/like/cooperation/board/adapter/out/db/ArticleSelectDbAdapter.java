package com.like.cooperation.board.adapter.out.db;

import com.like.cooperation.board.adapter.out.db.querydsl.ArticleSelectQuerydsl;
import com.like.cooperation.board.port.in.article.dto.ArticleOneDTO;
import com.like.cooperation.board.port.out.ArticleSelectDbPort;

public class ArticleSelectDbAdapter implements ArticleSelectDbPort {

	ArticleSelectQuerydsl query;
	
	ArticleSelectDbAdapter(ArticleSelectQuerydsl query) {
		this.query = query;
	}
	
	@Override
	public ArticleOneDTO get(Long id) {
		 ArticleOneDTO d = this.query.get(id);
		 
		return null;
	}

}
