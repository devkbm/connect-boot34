package com.like.cooperation.board.adapter.out.db.querydsl;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.domain.QArticle;
import com.like.cooperation.board.port.in.article.dto.ArticleFormSelectDTO;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ArticleSelectQuerydsl {
		
	private final QArticle qArticle = QArticle.article;	
	
	private JPAQueryFactory queryFactory;
	
	ArticleSelectQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}	
	
	
	public ArticleFormSelectDTO get(String readerUserId, Long articleId) {
		
		Expression<Boolean> editable = new CaseBuilder()
				.when(qArticle.userId.eq(readerUserId)).then(true)
				.otherwise(false)
				.as("editable");
		
		return queryFactory
				.select(
					Projections.fields(ArticleFormSelectDTO.class,
						qArticle.board.boardId,
						qArticle.articleId,
						qArticle.articleParentId,
						qArticle.userId.as("userName"),
						qArticle.content.title,
						qArticle.content.contents,
						qArticle.hitCount,
						qArticle.depth,
						editable
					))
			   .from(qArticle)				   
			   .where(qArticle.articleId.eq(articleId))
			   .fetchFirst();
	}	
	
}
