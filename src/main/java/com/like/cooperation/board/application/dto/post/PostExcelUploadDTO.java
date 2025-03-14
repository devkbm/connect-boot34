package com.like.cooperation.board.application.dto.post;

import com.like.excel.upload.ExcelHeader;

public class PostExcelUploadDTO {

	String clientAppUrl;
	String boardId;
	@ExcelHeader("제목")String title;
	@ExcelHeader("내용")String contents;
}
