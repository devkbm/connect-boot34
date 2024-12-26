package com.like.cooperation.board.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.domain.Post;
import com.like.cooperation.board.domain.PostQueryRepository;
import com.like.cooperation.board.domain.QPost;
import com.like.cooperation.board.domain.QPostAttachedFile;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PostQuerydsl implements PostQueryRepository {

	private JPAQueryFactory queryFactory;
	
	private final QPost qArticle = QPost.post;	
	private final QPostAttachedFile qAttachedFile = QPostAttachedFile.postAttachedFile;
	// private final QArticleCheck qArticleCheck = QArticleCheck.articleCheck;	
	
	public PostQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}	
	
	public List<Post> getArticleList(Long boardId) { 			
		
		return queryFactory.select(qArticle)
						   .from(qArticle)	
						   .leftJoin(qArticle.files, qAttachedFile)
						   .fetchJoin()
						   .where(qArticle.board.boardId.eq(boardId))							
						   .fetch();				
	}
	
	@Override
	public List<Post> getArticleList(Predicate condition) {
		return queryFactory.select(qArticle).distinct()
				   .from(qArticle)		  				   
				   .leftJoin(qArticle.files, qAttachedFile)
				   .fetchJoin()		  				   				   
				   .where(condition)
				   .orderBy(qArticle.articleId.desc())
				   .fetch();
	}	
	
}
