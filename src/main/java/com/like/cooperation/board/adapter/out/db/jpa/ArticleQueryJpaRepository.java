package com.like.cooperation.board.adapter.out.db.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.domain.Article;
import com.like.cooperation.board.domain.ArticleQueryRepository;
import com.like.cooperation.board.domain.QArticle;
import com.like.cooperation.board.domain.QArticleAttachedFile;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ArticleQueryJpaRepository implements ArticleQueryRepository {

	private JPAQueryFactory queryFactory;
	
	private final QArticle qArticle = QArticle.article;	
	private final QArticleAttachedFile qAttachedFile = QArticleAttachedFile.articleAttachedFile;
	// private final QArticleCheck qArticleCheck = QArticleCheck.articleCheck;	
	
	public ArticleQueryJpaRepository(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}	
	
	public List<Article> getArticleList(Long boardId) { 			
		
		return queryFactory.select(qArticle)
						   .from(qArticle)	
						   .leftJoin(qArticle.files, qAttachedFile)
						   .fetchJoin()
						   .where(qArticle.board.boardId.eq(boardId))							
						   .fetch();				
	}
	
	@Override
	public List<Article> getArticleList(Predicate condition) {
		return queryFactory.select(qArticle).distinct()
				   .from(qArticle)		  				   
				   .leftJoin(qArticle.files, qAttachedFile)
				   .fetchJoin()		  				   				   
				   .where(condition)
				   .orderBy(qArticle.articleId.desc())
				   .fetch();
	}	
	
}
