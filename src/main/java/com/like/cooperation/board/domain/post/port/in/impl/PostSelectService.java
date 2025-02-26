package com.like.cooperation.board.domain.post.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.domain.post.port.in.PostSelectUseCase;
import com.like.cooperation.board.domain.post.port.in.dto.PostFormSelectDTO;
import com.like.cooperation.board.domain.post.port.out.PostSelectDbPort;

@Service
public class PostSelectService implements PostSelectUseCase {
	

	PostSelectDbPort port;
	
	PostSelectService(PostSelectDbPort port) {				
		this.port = port;
	}
	
	@Override
	public PostFormSelectDTO select(String readerUserId, Long articleId) {
		
		return this.port.get(readerUserId, articleId);
	}

}
