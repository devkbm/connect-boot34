package com.like.cooperation.board.application.port.in.post;

import java.io.FileNotFoundException;

public interface PostAttachedFileDeleteUseCase {

	void delete(String postId, String fileId) throws FileNotFoundException;
}
