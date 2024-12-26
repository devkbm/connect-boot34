package com.like.cooperation.board.port.in.post.dto;

import com.like.cooperation.board.domain.Post;
import com.like.cooperation.board.domain.PostContents;
import com.like.cooperation.board.domain.PostPassword;
import com.like.cooperation.board.domain.Board;
import com.like.cooperation.board.util.Base64Util;

public class PostFormSaveDTOMapper {

	public static Post newArticle(PostFormSaveDTO dto, Board board) {	
		
		Post entity = Post.builder()	
							    .board(board)
							    .articleId(Base64Util.fromBase64Decode(dto.articleId()))
							    .userId(dto.userId())
							    .content(new PostContents(dto.title(), dto.contents()))						  						  
							    .password(new PostPassword(dto.pwd()))
							    .isFixedTop(dto.isFiexedTop())
							    .build();
		
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;
	}
    
    public static void modifyArticle(PostFormSaveDTO dto, Post entity) {	    		  	    	
    	entity.modifyEntity(new PostContents(dto.title(), dto.contents()), dto.isFiexedTop());
    	
    	entity.setAppUrl(dto.clientAppUrl());
	}
}
