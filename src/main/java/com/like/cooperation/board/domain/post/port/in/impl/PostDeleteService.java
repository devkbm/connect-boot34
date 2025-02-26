package com.like.cooperation.board.domain.post.port.in.impl;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.domain.post.port.in.PostDeleteUseCase;
import com.like.cooperation.board.domain.post.port.out.PostCommandDbPort;

@Service
public class PostDeleteService implements PostDeleteUseCase {

	PostCommandDbPort port;
	
	PostDeleteService(PostCommandDbPort port) {
		this.port = port;
	}
	
	@Override
	public void delete(Long articleId) {
		this.port.delete(articleId);		
	}

}
