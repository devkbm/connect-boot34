package com.like.cooperation.board.port.in.article.dto;

import static org.springframework.util.StringUtils.hasText;

import com.like.cooperation.board.domain.QArticle;
import com.like.cooperation.board.util.Base64Util;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

public record ArticleQueryDTO(
		String boardId,
		String title,
		String contents
		) {
	private static final QArticle qArticle = QArticle.article;
	
	public BooleanBuilder getBooleanBuilder() {
		BooleanBuilder builder = new BooleanBuilder();
		
		builder
			.and(qArticle.board.boardId.eq(Base64Util.fromBase64Decode(this.boardId)))
			.and(likeTitle(this.title))
			.and(likeContents(this.contents));											
		
		return builder;
	}
	
	private BooleanExpression likeTitle(String title) {
		return hasText(title) ? qArticle.content.title.like("%"+title+"%") : null;					
	}
	
	private BooleanExpression likeContents(String contents) {
		return hasText(contents) ? qArticle.content.contents.like("%"+contents+"%") : null;			
	}
	
}
