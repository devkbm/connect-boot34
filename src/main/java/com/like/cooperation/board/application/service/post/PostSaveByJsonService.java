package com.like.cooperation.board.application.service.post;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.like.cooperation.board.application.dto.post.PostFormSaveDTO;
import com.like.cooperation.board.application.dto.post.PostFormSaveDTOMapper;
import com.like.cooperation.board.application.port.in.post.PostSaveByJsonUseCase;
import com.like.cooperation.board.application.port.out.board.BoardCommandDbPort;
import com.like.cooperation.board.application.port.out.post.PostAttachedFileDbPort;
import com.like.cooperation.board.application.port.out.post.PostCommandDbPort;
import com.like.cooperation.board.domain.board.Board;
import com.like.cooperation.board.domain.post.Post;
import com.like.cooperation.board.domain.post.PostAttachedFile;
import com.like.cooperation.board.domain.post.PostAttachedFileConverter;
import com.like.cooperation.board.util.Base64Util;
import com.like.system.file.export.FileInfoDTO;
import com.like.system.file.export.FileInfoDTOSelectUseCase;
import com.like.system.file.export.FileUploadUseCase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		log.info(dto.toString());
		Board board = boardDbPort.select(Base64Util.fromBase64Decode(dto.boardId()))
								 .orElseThrow(() -> new IllegalArgumentException("존재 하지 않은 게시판입니다."));		
						
		Post entity = StringUtils.hasText(dto.postId()) ? this.findArticle(Base64Util.fromBase64Decode(dto.postId())) : null; 
								
		if (entity == null) {
			entity = PostFormSaveDTOMapper.create(dto, board); 
		} else {
			PostFormSaveDTOMapper.modify(dto, entity);
		}
				
		this.dbPort.save(entity);		
		
		if (dto.attachFile() != null) {
			List<FileInfoDTO> fileInfoList = findFileInfoList(dto.attachFile());
			
			// FileInfo를 AttachedFile로 변환한다.
			List<PostAttachedFile> attachedFileList = PostAttachedFileConverter.convert(entity, fileInfoList);
															
			entity.setFiles(attachedFileList);
			
			// 기존 첨부파일이 있을 경우 저장되는 파일이외의 첨부파일정보는 삭제
			if (entity.getAttachedFileInfoList() != null) {
				this.attachedFileDbPort.deleteNotMatched(attachedFileList);
			}
											
			this.attachedFileDbPort.save(attachedFileList);		
		} else {
			// 기존 첨부파일이 있을 경우 삭제
			if (entity.getAttachedFileInfoList() != null) {
				this.attachedFileDbPort.deleteAll(entity.getPostId());
			}
											
			entity.clearFiles();		
		}
		
	}
	
	private Post findArticle(Long postId) {
		return this.dbPort.select(postId).orElse(null);
	}
	
	private List<FileInfoDTO> findFileInfoList(List<String> ids) {
		return fileSelectUseCase.select(ids); 
	}

}
