package com.like.cooperation.board.domain.post.port.in;

import com.like.cooperation.board.domain.post.port.in.dto.PostFormSelectDTO;

public interface PostSelectUseCase {
	PostFormSelectDTO select(String readerUserId, Long articleId);	
}
