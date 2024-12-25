package com.like.cooperation.board.adapter.out.db;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.like.cooperation.board.adapter.out.db.data.ArticleAttachedFileRepository;
import com.like.cooperation.board.domain.ArticleAttachedFile;
import com.like.cooperation.board.port.out.ArticleAttachedFileDbPort;

@Repository
public class ArticleAttachedFileDbAdapter implements ArticleAttachedFileDbPort {

	ArticleAttachedFileRepository repository;
	
	ArticleAttachedFileDbAdapter(ArticleAttachedFileRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void save(List<ArticleAttachedFile> files) {
		this.repository.saveAll(files);
	}

}
