package com.like.cooperation.board.adapter.out.db.querydsl;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.domain.QArticle;
import com.like.cooperation.board.domain.QArticleAttachedFile;
import com.like.cooperation.board.port.in.article.dto.ArticleResponseDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ArticleSelectQuerydsl {
		
	private final QArticle qArticle = QArticle.article;	
	private final QArticleAttachedFile qAttachedFile = QArticleAttachedFile.articleAttachedFile;
	
	private JPAQueryFactory queryFactory;
	
	ArticleSelectQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}	
	
	
	public ArticleResponseDTO get(Long id) {
		return queryFactory
				.select(
					Projections.fields(ArticleResponseDTO.class,
						qArticle.board.boardId,
						qArticle.articleId,
						qArticle.articleParentId,
						qArticle.content.title,
						qArticle.content.contents
					))
			   .from(qArticle)	
			   .leftJoin(qArticle.files, qAttachedFile)
			   .fetchJoin()
			   .where(qArticle.articleId.eq(id))
			   //.groupBy(qArticle)
			   .fetchFirst();
	}	
	
}
