package com.like.cooperation.board.domain.post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.like.system.file.export.FileInfoDTO;

public class PostAttachedFileConverter {

	public static List<PostAttachedFile> convert(Post post, List<FileInfoDTO> fileInfoList) {
		
		if (fileInfoList == null || fileInfoList.isEmpty()) return Collections.emptyList();
		
		List<PostAttachedFile> list = new ArrayList<>();
		
		List<PostAttachedFile> attachedFiles = post.getAttachedFileInfoList();
		
		// 1. 기존 첨부파일과 동일한 파일을 찾는다
		for (PostAttachedFile file : attachedFiles) {			
			if (isMatch(fileInfoList, file)) {
				list.add(file);
			}									
		}
				
		
		// 2. 기존 첨부파일 명단 중 없는 파일 신규 추가한다.
		for (FileInfoDTO file : fileInfoList) {
								
			if (isNotMatch(attachedFiles, file)) {
				list.add(new PostAttachedFile(post, file.fildId()));
			}
		}
		
		return list;				
	}	
	
	private static boolean isMatch(List<FileInfoDTO> list, PostAttachedFile file) {			
		return list.stream().anyMatch(e -> e.fildId().equals(file.fileInfo.toString()));
	}
	
	private static boolean isNotMatch(List<PostAttachedFile> list, FileInfoDTO file) {			
		return list.stream().noneMatch(e -> e.fileInfo.toString().equals(file.fildId()));
	}
	
}
