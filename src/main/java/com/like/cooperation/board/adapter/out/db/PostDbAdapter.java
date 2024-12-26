package com.like.cooperation.board.adapter.out.db;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.PostRepository;
import com.like.cooperation.board.adapter.out.db.data.BoardRepository;
import com.like.cooperation.board.domain.Post;
import com.like.cooperation.board.port.out.PostCommandDbPort;

@Repository
public class PostDbAdapter implements PostCommandDbPort {
	PostRepository repository;
	BoardRepository boardRepository;	
	
	PostDbAdapter(PostRepository repository
			        ,BoardRepository boardRepository) {
		this.repository = repository;
		this.boardRepository = boardRepository;		
	}

	@Override
	public Optional<Post> select(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public void save(Post entity) {
		this.repository.save(entity);
	}	
	
	@Override
	public void delete(Long id) {
		this.repository.deleteById(id);
		
	}	
	
}
