package com.like.cooperation.board.port.out;

import java.util.Optional;

import com.like.cooperation.board.domain.Post;

public interface PostCommandDbPort {
	Optional<Post> select(Long id);
	
	void save(Post entity);	
	
	void delete(Long id);
}
