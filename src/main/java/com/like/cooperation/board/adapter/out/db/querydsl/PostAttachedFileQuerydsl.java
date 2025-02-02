package com.like.cooperation.board.adapter.out.db.querydsl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.domain.PostAttachedFile;
import com.like.cooperation.board.domain.QPostAttachedFile;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class PostAttachedFileQuerydsl {

	JPAQueryFactory queryFactory;
	
	private final QPostAttachedFile qAttachedFile = QPostAttachedFile.postAttachedFile;
		
	public PostAttachedFileQuerydsl(JPAQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}
	
	public void deleteNotMatched(List<PostAttachedFile> files) {
		List<Long> ids = files.stream()
							  .filter(e -> e.getPkArticleFile() != null)
							  .map(e -> e.getPkArticleFile())
							  .toList();
		
		queryFactory.delete(qAttachedFile)
				    .where(qAttachedFile.pkArticleFile.notIn(ids))
				    .execute();
	}
	
	public void deleteAll(Long postId) {
		queryFactory.delete(qAttachedFile)
	    			.where(qAttachedFile.post.postId.eq(postId))
	    			.execute();
	}
	
	
}
