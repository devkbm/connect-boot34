package com.like.cooperation.board.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.PostAttachedFileRepository;
import com.like.cooperation.board.adapter.out.db.querydsl.PostAttachedFileQuerydsl;
import com.like.cooperation.board.domain.PostAttachedFile;
import com.like.cooperation.board.port.out.PostAttachedFileDbPort;

@Repository
public class PostAttachedFileDbAdapter implements PostAttachedFileDbPort {

	PostAttachedFileRepository repository;
	
	PostAttachedFileQuerydsl querydsl;
	
	PostAttachedFileDbAdapter(PostAttachedFileRepository repository, PostAttachedFileQuerydsl querydsl) {
		this.repository = repository;
		this.querydsl = querydsl;
	}
	
	@Override
	public void save(List<PostAttachedFile> files) {
		this.repository.saveAll(files);
	}
	
	@Override
	public void delete(Long postFileId) {
		this.repository.deleteById(postFileId);		
	}

	@Override
	public void deleteNotMatched(List<PostAttachedFile> files) {
		this.querydsl.deleteNotMatched(files);		
	}

	@Override
	public void deleteAll(Long postId) {
		this.querydsl.deleteAll(postId);		
	}

	

}
