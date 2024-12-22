package com.like.system.holiday.adapter.in.web;

import static com.like.core.web.util.ResponseEntityUtil.toOne;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.like.core.message.MessageUtil;
import com.like.system.holiday.port.in.HolidaySelectUseCase;
import com.like.system.holiday.port.in.dto.HolidaySaveDTO;

@RestController
public class HolidaySelectController {

	private HolidaySelectUseCase useCase;			
	
	public HolidaySelectController(HolidaySelectUseCase useCase) {
		this.useCase = useCase;			
	}		
	
	@GetMapping("/api/system/holiday/{date}")
	public ResponseEntity<?> getHoliday(@RequestParam String companyCode,
			                            @PathVariable @DateTimeFormat(pattern="yyyyMMdd") LocalDate date) {
				
		HolidaySaveDTO dto = this.useCase.select(companyCode, date);
		
		return toOne(dto, MessageUtil.getQueryMessage(dto == null ? 0 : 1));
	}		
}