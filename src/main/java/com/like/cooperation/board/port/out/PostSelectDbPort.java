package com.like.cooperation.board.port.out;

import com.like.cooperation.board.port.in.post.dto.PostFormSelectDTO;

public interface PostSelectDbPort {

	PostFormSelectDTO get(String readerUserId, Long articleId);
}
