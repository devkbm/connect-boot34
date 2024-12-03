package com.like.hrm.staff.adapter.in.web.appointment;

import static com.like.core.web.util.ResponseEntityUtil.toList;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.like.core.message.MessageUtil;
import com.like.hrm.staff.port.in.appointment.StaffAppointmentQueryUseCase;
import com.like.hrm.staff.port.in.appointment.StaffAppointmentRecordDTO;

public class StaffAppointmentQueryController {

	StaffAppointmentQueryUseCase useCase;
	
	public StaffAppointmentQueryController(StaffAppointmentQueryUseCase useCase) {
		this.useCase = useCase;
	}
	
	@GetMapping("/api/hrm/staff/{staffId}/appointmentrecord")
	public ResponseEntity<?> getAppointmentRecordList(@RequestParam String companyCode, @PathVariable String staffId) {
										
		List<StaffAppointmentRecordDTO> list = useCase.select(companyCode, staffId); 		
		
		return toList(list, MessageUtil.getQueryMessage(list.size()));
	}
}
