package com.like.cooperation.board.port.in.post;

import com.like.cooperation.board.port.in.post.dto.PostSaveMultipartDTO;

public interface PostSaveByMultiPartUseCase {	
	
	void save(PostSaveMultipartDTO dto);
		
}
