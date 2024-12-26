package com.like.cooperation.board.port.out;

import com.like.cooperation.board.domain.Post;

public interface PostUserHitCountDbPort {
	void plusHitCount(Post article, String userId);
}
