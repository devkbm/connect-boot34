package com.like.hrm.staff.application.port.in;

import java.util.List;

import com.like.hrm.staff.application.dto.StaffCreateExcelUploadDTO;

public interface StaffCreateExcelUploadUseCase {

	void upload(List<StaffCreateExcelUploadDTO> dtos);
}
