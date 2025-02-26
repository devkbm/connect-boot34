package com.like.cooperation.board.domain.post.port.out;

import com.like.cooperation.board.domain.post.port.in.dto.PostFormSelectDTO;

public interface PostSelectDbPort {

	PostFormSelectDTO get(String readerUserId, Long articleId);
}
