package com.like.cooperation.board.port.in.article.dto;

import com.like.cooperation.board.domain.Article;
import com.like.cooperation.board.domain.ArticleContents;
import com.like.cooperation.board.domain.ArticlePassword;
import com.like.cooperation.board.domain.Board;
import com.like.cooperation.board.util.Base64Util;

public class ArticleFormSaveDTOMapper {

	public static Article newArticle(ArticleFormSaveDTO dto, Board board) {	
		
		Article entity = Article.builder()	
							    .board(board)
							    .articleId(Base64Util.fromBase64Decode(dto.articleId()))
							    .userId(dto.userId())
							    .content(new ArticleContents(dto.title(), dto.contents()))						  						  
							    .password(new ArticlePassword(dto.pwd()))
							    .isFixedTop(dto.isFiexedTop())
							    .build();
		
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;
	}
    
    public static void modifyArticle(ArticleFormSaveDTO dto, Article entity) {	    		  	    	
    	entity.modifyEntity(new ArticleContents(dto.title(), dto.contents()), dto.isFiexedTop());
    	
    	entity.setAppUrl(dto.clientAppUrl());
	}
}
