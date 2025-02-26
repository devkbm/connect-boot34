package com.like.cooperation.board.domain.post.port.in;

public interface PostAttachedFileDeleteUseCase {

	void delete(String postId, String fileId);
}
