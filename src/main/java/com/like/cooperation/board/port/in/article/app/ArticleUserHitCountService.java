package com.like.cooperation.board.port.in.article.app;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.domain.Article;
import com.like.cooperation.board.port.in.article.ArticleUserHitCountUseCase;
import com.like.cooperation.board.port.out.ArticleCommandDbPort;
import com.like.cooperation.board.port.out.ArticleUserHitCountDbPort;

@Service
public class ArticleUserHitCountService implements ArticleUserHitCountUseCase {
	
	ArticleUserHitCountDbPort port;
	ArticleCommandDbPort articlePort;
	
	ArticleUserHitCountService(ArticleUserHitCountDbPort port
							  ,ArticleCommandDbPort articlePort) {
		this.port = port;				
		this.articlePort = articlePort;
	}
	
	@Override
	public void plusHitCount(Long articleId, String userId) {
		Article article = this.articlePort.select(articleId)
										  .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시글입니다."));
		
		article.updateHitCnt();
		
		this.port.plusHitCount(article, userId);
	}	

}
