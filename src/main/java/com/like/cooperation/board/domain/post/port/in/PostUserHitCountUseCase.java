package com.like.cooperation.board.domain.post.port.in;

public interface PostUserHitCountUseCase {

	void plusHitCount(Long articleId, String userId);
}
