package com.like.cooperation.board.port.in.post.dto;

import com.like.cooperation.board.domain.Post;
import com.like.cooperation.board.domain.PostContents;
import com.like.cooperation.board.domain.PostPassword;
import com.like.cooperation.board.domain.Board;
import com.like.cooperation.board.util.Base64Util;

public class PostFormSaveDTOMapper {

	public static Post create(PostFormSaveDTO dto, Board board) {	
		
		Post entity = Post.builder()	
							    .board(board)
							    .postId(Base64Util.fromBase64Decode(dto.postId()))
							    .userId(dto.userId())
							    .content(new PostContents(dto.title(), dto.contents()))						  						  
							    .password(new PostPassword(dto.pwd()))
							    .isFixedTop(dto.isFiexedTop())
							    .build();
		
		entity.setAppUrl(dto.clientAppUrl());
		
		return entity;
	}
    
    public static void modify(PostFormSaveDTO dto, Post entity) {	    		  	    	
    	entity.modify(dto.clientAppUrl(), new PostContents(dto.title(), dto.contents()), dto.isFiexedTop());
    	    	
	}
}
