package com.like.cooperation.board.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.PostAttachedFileRepository;
import com.like.cooperation.board.domain.PostAttachedFile;
import com.like.cooperation.board.port.out.PostAttachedFileDbPort;

@Repository
public class PostAttachedFileDbAdapter implements PostAttachedFileDbPort {

	PostAttachedFileRepository repository;
	
	PostAttachedFileDbAdapter(PostAttachedFileRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void save(List<PostAttachedFile> files) {
		this.repository.saveAll(files);
	}

}
