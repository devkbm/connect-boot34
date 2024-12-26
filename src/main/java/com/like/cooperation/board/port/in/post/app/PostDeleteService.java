package com.like.cooperation.board.port.in.post.app;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.port.in.post.PostDeleteUseCase;
import com.like.cooperation.board.port.out.PostCommandDbPort;

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
