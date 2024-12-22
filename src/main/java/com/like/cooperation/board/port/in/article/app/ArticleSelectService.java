package com.like.cooperation.board.port.in.article.app;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.like.cooperation.board.domain.Article;
import com.like.cooperation.board.port.in.article.ArticleSelectUseCase;
import com.like.cooperation.board.port.in.article.dto.ArticleResponseDTO;
import com.like.cooperation.board.port.in.article.dto.ArticleResponseDTOMapper;
import com.like.cooperation.board.port.out.ArticleCommandDbPort;
import com.like.system.file.export.FileInfoDTO;
import com.like.system.file.export.FileInfoDTOSelectUseCase;

@Service
public class ArticleSelectService implements ArticleSelectUseCase {

	ArticleCommandDbPort dbPort;	
	FileInfoDTOSelectUseCase fileSelectUseCase;
	
	ArticleSelectService(ArticleCommandDbPort dbPort						
						,FileInfoDTOSelectUseCase fileSelectUseCase) {		
		this.dbPort = dbPort;		
		this.fileSelectUseCase = fileSelectUseCase;
	}
	
	@Override
	public ArticleResponseDTO select(Long id) {
		Article entity = this.dbPort.select(id).orElse(null);
		List<FileInfoDTO> fileList = Collections.emptyList();
		
		if (entity.getAttachedFileInfoList() != null) {
			fileList = fileSelectUseCase.select(entity.getFileIds());
		}
		
		return ArticleResponseDTOMapper.toDTO(this.dbPort.select(id).orElse(null), fileList);
	}

}
