package com.like.cooperation.board.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.like.system.file.export.FileInfoDTO;

public class PostAttachedFileConverter {

	public static List<PostAttachedFile> convert(Post article, List<FileInfoDTO> fileInfoList) {
		
		if (fileInfoList == null || fileInfoList.isEmpty()) return Collections.emptyList();
		
		List<PostAttachedFile> list = new ArrayList<>();
		
		List<PostAttachedFile> existList = article.getAttachedFileInfoList();
		
		for (FileInfoDTO file : fileInfoList) {
								
			if (isNotExists(existList, file)) {
				list.add(new PostAttachedFile(article, file.fildId()));
			}
		}
		
		return list;				
	}
	
	private static boolean isNotExists(List<PostAttachedFile> list, FileInfoDTO file) {			
		return list.stream().noneMatch(e -> e.fileInfo.toString().equals(file.fildId()));
	}
	
}
