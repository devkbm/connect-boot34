package com.like.cooperation.board.domain.post.port.out;

import com.like.cooperation.board.domain.post.Post;

public interface PostUserHitCountDbPort {
	void plusHitCount(Post article, String userId);
}
