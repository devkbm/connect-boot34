package com.like.cooperation.board.port.in.post;

import com.like.cooperation.board.port.in.post.dto.PostFormSaveDTO;

public interface PostSaveByJsonUseCase {
	void save(PostFormSaveDTO dto);	
}
