package com.like.cooperation.board.domain.post.port.out;

import java.util.List;

import com.like.cooperation.board.domain.post.PostAttachedFile;

public interface PostAttachedFileDbPort {
	void save(List<PostAttachedFile> files);
	
	void delete(Long postFileId);
	
	void deleteAll(Long postId);
	
	void deleteNotMatched(List<PostAttachedFile> files);
	
	
}
