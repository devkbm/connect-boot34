package com.like.cooperation.board.port.in.post;

import com.like.cooperation.board.port.in.post.dto.PostFormSelectDTO;

public interface PostSelectUseCase {
	PostFormSelectDTO select(String readerUserId, Long articleId);	
}
