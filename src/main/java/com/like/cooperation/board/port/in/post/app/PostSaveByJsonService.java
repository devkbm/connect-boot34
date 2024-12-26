package com.like.cooperation.board.port.in.post.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.like.cooperation.board.domain.Post;
import com.like.cooperation.board.domain.PostAttachedFile;
import com.like.cooperation.board.domain.PostAttachedFileConverter;
import com.like.cooperation.board.domain.Board;
import com.like.cooperation.board.port.in.post.PostSaveByJsonUseCase;
import com.like.cooperation.board.port.in.post.dto.PostFormSaveDTO;
import com.like.cooperation.board.port.in.post.dto.PostFormSaveDTOMapper;
import com.like.cooperation.board.port.out.PostAttachedFileDbPort;
import com.like.cooperation.board.port.out.PostCommandDbPort;
import com.like.cooperation.board.port.out.BoardCommandDbPort;
import com.like.cooperation.board.util.Base64Util;
import com.like.system.file.export.FileInfoDTO;
import com.like.system.file.export.FileInfoDTOSelectUseCase;
import com.like.system.file.export.FileUploadUseCase;

@Transactional
@Service
public class PostSaveByJsonService implements PostSaveByJsonUseCase {

	BoardCommandDbPort boardDbPort;
	PostCommandDbPort dbPort;
	PostAttachedFileDbPort attachedFileDbPort;
	
	FileUploadUseCase uploadUseCase;	
	FileInfoDTOSelectUseCase fileSelectUseCase;
	
	
	PostSaveByJsonService(
			BoardCommandDbPort boardDbPort,
			PostCommandDbPort dbPort,			
			PostAttachedFileDbPort attachedFileDbPort,
			FileUploadUseCase uploadUseCase,
			FileInfoDTOSelectUseCase fileSelectUseCase
			) {
		this.dbPort = dbPort;
		this.boardDbPort = boardDbPort;
		this.attachedFileDbPort = attachedFileDbPort;
		this.uploadUseCase = uploadUseCase;		
		this.fileSelectUseCase = fileSelectUseCase;
	}
	
	@Override
	public void save(PostFormSaveDTO dto) {
		Board board = boardDbPort.select(Base64Util.fromBase64Decode(dto.boardId()))
								 .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시판입니다."));		
						
		Post entity = StringUtils.hasText(dto.articleId()) ? this.findArticle(dto.articleId()) : null; 
								
		if (entity == null) {
			entity = PostFormSaveDTOMapper.newArticle(dto, board); 
		} else {
			PostFormSaveDTOMapper.modifyArticle(dto, entity);
		}
				
		this.dbPort.save(entity);		
		
		if (dto.attachFile() != null) {
			List<FileInfoDTO> fileInfoList = findFileInfoList(dto.attachFile());
			
			// FileInfo를 AttachedFile로 변환한다.
			List<PostAttachedFile> attachedFileList = PostAttachedFileConverter.convert(entity, fileInfoList);
															
			if (!attachedFileList.isEmpty()) entity.setFiles(attachedFileList);
						
			this.attachedFileDbPort.save(attachedFileList);		
		}		
		
	}
	
	private Post findArticle(String articleId) {
		return this.dbPort.select(Base64Util.fromBase64Decode(articleId)).orElse(null);
	}
	
	private List<FileInfoDTO> findFileInfoList(List<String> ids) {
		return fileSelectUseCase.select(ids); 
	}

}
