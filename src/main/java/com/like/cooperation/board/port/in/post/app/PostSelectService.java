package com.like.cooperation.board.port.in.post.app;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.port.in.post.PostSelectUseCase;
import com.like.cooperation.board.port.in.post.dto.PostFormSelectDTO;
import com.like.cooperation.board.port.out.PostSelectDbPort;

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
