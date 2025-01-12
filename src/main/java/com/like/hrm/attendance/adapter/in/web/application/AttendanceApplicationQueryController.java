package com.like.hrm.attendance.adapter.in.web.application;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.attendance.port.in.application.AttendanceApplicationQueryUseCase;
import com.like.hrm.attendance.port.in.application.dto.AttendanceApplicationQueryResultDTO;
import com.like.hrm.attendance.port.in.application.dto.DutyApplicationDTO;

@RestController
public class AttendanceApplicationQueryController {

	AttendanceApplicationQueryUseCase useCase;
	
	AttendanceApplicationQueryController(AttendanceApplicationQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/dutyapplication")
	public ResponseEntity<?> getDutyApplicationList(DutyApplicationDTO.Search dto) {
											
		List<AttendanceApplicationQueryResultDTO> list = useCase.select(dto.staffId());
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
