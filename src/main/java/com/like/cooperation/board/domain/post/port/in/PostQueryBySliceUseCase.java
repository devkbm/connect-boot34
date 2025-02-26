package com.like.cooperation.board.domain.post.port.in;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.like.cooperation.board.domain.post.port.in.dto.PostListDTO;
import com.like.cooperation.board.domain.post.port.in.dto.PostQueryDTO;

public interface PostQueryBySliceUseCase {
	
	Slice<PostListDTO> getAritlceSlice(String userId, PostQueryDTO dto, Pageable pageable);
}
