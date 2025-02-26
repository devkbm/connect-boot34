package com.like.cooperation.board.domain.post.port.in;

import com.like.cooperation.board.domain.post.port.in.dto.PostSaveMultipartDTO;

public interface PostSaveByMultiPartUseCase {	
	
	void save(PostSaveMultipartDTO dto);
		
}
