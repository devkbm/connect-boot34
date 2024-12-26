package com.like.cooperation.board.port.in.post;

public interface PostUserHitCountUseCase {

	void plusHitCount(Long articleId, String userId);
}
