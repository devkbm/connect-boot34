package com.like.cooperation.board.port.out;

import java.util.List;

import com.like.cooperation.board.domain.ArticleAttachedFile;

public interface ArticleAttachedFileDbPort {
	void save(List<ArticleAttachedFile> files);
}
