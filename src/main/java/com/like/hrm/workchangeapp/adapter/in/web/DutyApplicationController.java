package com.like.hrm.workchangeapp.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;
import static com.like.core.web.util.ResponseEntityUtil.toOne;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.hrm.workchangeapp.domain.WorkChangeApplication;
import com.like.hrm.workchangeapp.port.in.DutyApplicationDTO;
import com.like.hrm.workchangeapp.port.in.app.DutyApplicationCommandService;
import com.like.hrm.workchangeapp.port.in.app.DutyApplicationQueryService;
import com.like.system.holiday.port.in.DateInfoSelectUseCase;

@RestController
public class DutyApplicationController {

	private DutyApplicationCommandService dutyApplicationCommandService;
	
	private DutyApplicationQueryService dutyApplicationQueryService;		
	
	private DateInfoSelectUseCase holidayUtilService;
	
	public DutyApplicationController(DutyApplicationCommandService dutyApplicationCommandService
									,DutyApplicationQueryService dutyApplicationQueryService									
									,DateInfoSelectUseCase holidayUtilService) {
		this.dutyApplicationCommandService = dutyApplicationCommandService;
		this.dutyApplicationQueryService = dutyApplicationQueryService;		
		this.holidayUtilService = holidayUtilService;
	}
	
	@GetMapping("/api/hrm/dutyapplication")
	public ResponseEntity<?> getDutyApplicationList(DutyApplicationDTO.Search dto) {
											
		List<DutyApplicationDTO.Form> list = dutyApplicationQueryService.getDutyApplicationList(dto)
																					   .stream()
																					   .map(e -> DutyApplicationDTO.Form.convert(e, holidayUtilService))
																					   .toList();
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
	
	@GetMapping("/api/hrm/dutyapplication/{id}")
	public ResponseEntity<?> getDutyApplication(@PathVariable Long id) {
		
		WorkChangeApplication entity = dutyApplicationCommandService.getDutyApplication(id);
						
		DutyApplicationDTO.Form dto = DutyApplicationDTO.Form.convert(entity, holidayUtilService);			
				
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}
	
	@GetMapping("/api/hrm/dutyapplication/period/{from}/{to}/{companyCode}")
	public ResponseEntity<?> getDutyApplicationPeriod(@PathVariable @DateTimeFormat(pattern="yyyyMMdd")LocalDate from
													 ,@PathVariable @DateTimeFormat(pattern="yyyyMMdd")LocalDate to
													 ,@PathVariable String companyCode ) {
						
		List<DutyApplicationDTO.DutyDate> list = DutyApplicationDTO.DutyDate.convertInitDutyDateList(holidayUtilService.select(companyCode, from, to));			
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
		
	@PostMapping("/api/hrm/dutyapplication")
	public ResponseEntity<?> saveDutyApplication(@RequestBody DutyApplicationDTO.Form dto) {				
																			
		dutyApplicationCommandService.saveDutyApplication(dto);						
								 					
		return toList(null, MessageUtil.getSaveMessage(1));
	}
	
	@DeleteMapping("/api/hrm/dutyapplication/{id}")
	public ResponseEntity<?> deleteDutyApplication(@PathVariable Long id) {				
																		
		dutyApplicationCommandService.deleteDutyApplication(id);						
								 					
		return toList(null, MessageUtil.getDeleteMessage(1));
	}	
		
}
